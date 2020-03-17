package com.test.Kstream.springCloud;

import java.util.function.Function;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;

import com.test.Kstream.entities.UserEntity;

public interface StreamCloudI {

	Function<KStream<String, BankingInfosDto>, KStream<String, BankingInfosDto>[]> process();

	Function<BankingInfosDto, Message<BankingInfosDto>> sink();

}