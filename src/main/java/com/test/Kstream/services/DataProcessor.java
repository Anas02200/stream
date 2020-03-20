package com.test.Kstream.services;

import java.util.function.Function;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.messaging.Message;

public interface DataProcessor {

	Function<KStream<String, BankingInfosDto>, KStream<String, BankingInfosDto>[]> process();

	Function<BankingInfosDto, Message<BankingInfosDto>> sink();

}