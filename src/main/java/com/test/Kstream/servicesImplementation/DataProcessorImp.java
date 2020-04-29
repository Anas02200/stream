package com.test.Kstream.servicesImplementation;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import com.test.Kstream.entities.BankTransactionEntity;
import com.test.Kstream.services.DataProcessor;
import com.test.Kstream.services.MapDtoToEntity;
import com.test.Kstream.services.TransactionProcessor;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class DataProcessorImp implements DataProcessor {
    //this logic will be a service later
    @Autowired
    @Qualifier("MapDtoToTransaction")
    MapDtoToEntity mapDtoToEntity;

    @Autowired
    TransactionProcessor transactionProcessor;


    @Bean
    public Function<KStream<String, BankingInfosDto>, KStream<String, BankingInfosDto>[]> process() {

        //add logic later
        Predicate<String, BankingInfosDto> sendEmail = (k, v) -> v.getFullName().matches("anas");
        Predicate<String, BankingInfosDto> sendNotification = (k, v) -> v.getFullName().matches("anaas");
        Predicate<String, BankingInfosDto> confirmTransaction = (k, v) -> !v.getFullName().equals("yeey");
        //testing processing for the moment
        return input -> {
            input.mapValues(value -> {
                BankTransactionEntity bankTransactionEntity = (BankTransactionEntity) this.mapDtoToEntity
                        .MapToEntity(value.getTransactionData(), BankTransactionEntity.class);
                try {
                    mapDtoToEntity.SetEntityFields(value, bankTransactionEntity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                transactionProcessor.processTransaction(bankTransactionEntity);

                System.out.println("Processing :: " + bankTransactionEntity.getReceiverName() + bankTransactionEntity.getFullName());
                return value;
            });

            return input.branch(sendEmail, sendNotification);
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
/*
	@Bean
	public Consumer<String> receive() {
		return data -> System.out.println("Data received..." + data);
	}
*/
}
