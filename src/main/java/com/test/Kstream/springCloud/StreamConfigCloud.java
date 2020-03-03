package com.test.Kstream.springCloud;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;

import org.apache.kafka.streams.kstream.KStream;
import org.apache.kafka.streams.kstream.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import com.test.Kstream.entities.UserEntity;

@Component
public class StreamConfigCloud {
	@SuppressWarnings("unchecked")
	@Bean
	public Function<KStream<String, UserEntity>, KStream<String, UserEntity>[]> process() {

		Predicate<String, UserEntity> isGood = (k, v) -> v.getCardNumber()<1000;
		Predicate<String, UserEntity> isntGood = (k, v) -> v.getCardNumber()>1000;

		return input -> input.mapValues(v -> {
			v.setCardNumber((long) (Math.random() * 10000));
			byte[] array = new byte[7]; // length is bounded by 7 new
			new Random().nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));
			v.setName(generatedString);

			System.out.println("Processing :: " + v + "name : " + v.getName() + "card number :" + v.getCardNumber());
			return v;

		}).branch(isGood,isntGood);

	}

	@Bean
	public Function<UserEntity, Message<UserEntity>> sink() {
		return input -> {
			Message<UserEntity> message = MessageBuilder.withPayload(input).setHeader("key", "lol").build();
			
			System.out.println(message);
			return message;

		};

	};
	
	/*@Bean
	public Consumer<String> receive() {
		return data -> System.out.println("Data received..." + data);
	}
*/
}
