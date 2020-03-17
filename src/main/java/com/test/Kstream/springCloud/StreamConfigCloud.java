package com.test.Kstream.springCloud;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.test.Kstream.entities.UserEntity;

@Component
public class StreamConfigCloud implements StreamCloudI {

	@Bean
	public Function<KStream<String, BankingInfosDto>, KStream<String, BankingInfosDto>[]> process() {

		//add logic later
		Predicate<String, BankingInfosDto> sendEmail = (k, v) -> v.getFullName().matches("anas");
		Predicate<String, BankingInfosDto> sendNotification = (k, v) -> v.getFullName().matches("anaas");
		Predicate<String, BankingInfosDto> confirmTransaction = (k, v) -> !v.getFullName().equals("yeey");

		//testing processing for the moment
		return input -> {
			KStream<String, BankingInfosDto> w413200 = input.mapValues(v -> {
				//v.setFullName("bouarafa");
				byte[] array = new byte[7]; // length is bounded by 7 new
				new Random().nextBytes(array);
				String generatedString = new String(array, StandardCharsets.UTF_8);
				v.setIdentityCardNumber("w413200");

				System.out.println("Processing :: " + v + " name : " + v.getFullName() + " card number :" + v
						.getIdentityCardNumber());
				return v;

			});
			return input.branch(sendEmail,sendNotification);
		};

	}

	/* (non-Javadoc)
	 * @see com.test.Kstream.springCloud.StreamCloudI#sink()
	 */
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
