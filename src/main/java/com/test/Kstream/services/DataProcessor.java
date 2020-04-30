package com.test.Kstream.services;

import java.util.function.Function;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.messaging.Message;

public interface DataProcessor {

	float helperFunction(BankingInfosDto bankingInfosDto);

	Function<KStream<String, BankingInfosDto>, KStream<String, String>[]> process();

	Function<String, Message<String>> sink();

}