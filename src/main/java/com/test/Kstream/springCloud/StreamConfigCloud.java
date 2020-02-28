package com.test.Kstream.springCloud;

import java.nio.charset.Charset;
import java.util.Random;

import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

import com.test.Kstream.entities.UserEntity;

@EnableBinding(ProducerChannel.class)
@Component
public class StreamConfigCloud {

	@StreamListener
	@SendTo(ProducerChannel.treateduser)
	public KStream<String, UserEntity> process(

			@Input(ProducerChannel.instream) KStream<String, UserEntity> stream) {
		return stream.mapValues(v -> {
			v.setCardNumber((long) (Math.random() * 10000));
			byte[] array = new byte[7]; // length is bounded by 7 new
			new Random().nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));
			v.setName(generatedString);

			System.out.println("Processing :: " + v + "name : " +v.getName()+ "card number :"+v.getCardNumber());
			return v;

		});

	}

}
