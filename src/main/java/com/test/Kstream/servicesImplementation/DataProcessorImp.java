package com.test.Kstream.servicesImplementation;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.services.DataProcessor;
import com.test.Kstream.services.MapDtoToEntity;
import com.test.Kstream.services.TransactionProcessor;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DataProcessorImp implements DataProcessor {
    //this logic will be a service later
    private final MapDtoToEntity mapDtoToEntity;

    private final TransactionProcessor transactionProcessor;
    private float dis = 1f;

    public DataProcessorImp(@Qualifier("MapDtoToTransaction") MapDtoToEntity mapDtoToEntity, TransactionProcessor transactionProcessor) {
        this.mapDtoToEntity = mapDtoToEntity;
        this.transactionProcessor = transactionProcessor;
    }


    @Override
    public float helperFunction(BankingInfosDto value) {
        BankTransactionEntity bankTransactionEntity = (BankTransactionEntity) this.mapDtoToEntity
                .MapToEntity(value.getTransactionData(), BankTransactionEntity.class);
        try {
            mapDtoToEntity.SetEntityFields(value, bankTransactionEntity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return transactionProcessor.processTransaction(bankTransactionEntity);
    }

    @Bean
    public Function<KStream<String, BankingInfosDto>, KStream<String, BankingInfosDto>[]> process() {

        Predicate<String, BankingInfosDto> confirmTransaction = (k, value) -> (dis) < 0.05f;

        Predicate<String, BankingInfosDto> sendNotification = (k, value) -> (dis) <= 0.6f;

        Predicate<String, BankingInfosDto> sendSms = (k, value) -> (dis) > 0.6f;
        //testing processing for the moment
        return input -> {

            input.mapValues(value -> {

                this.dis = helperFunction(value);
                System.out.println("dddistance is :" + this.dis);
                return dis;
            });


            return input.branch(confirmTransaction, sendNotification, sendSms);
        };

    }


    @Override
    @Bean
    public Function<BankingInfosDto, Message<BankingInfosDto>> sink() {
        return input -> {
            Message<BankingInfosDto> message = MessageBuilder.withPayload(input).setHeader("key", "lol").build();

            System.out.println(message);
            return message;

        };

    }

}
