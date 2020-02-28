package com.test.Kstream.config;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.common.serialization.Serializer;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.apache.tomcat.util.http.fileupload.util.Streams;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;
import org.springframework.kafka.support.serializer.JsonSerde;

import com.test.Kstream.entities.UserEntity;
import com.test.Kstream.serializers.JsonPOJODeserializer;
import com.test.Kstream.serializers.JsonPOJOSerializer;
import com.test.Kstream.serializers.UserSerde;

//@Configuration
//@EnableKafka
//@EnableKafkaStreams
public class StreamConfig {

	@Value("${kafka.topic.input}")
	private String inputTopic;

	@Value("${kafka.topic.even-output}")
	private String outputTopic;

	@Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
	public KafkaStreamsConfiguration kStreamsConfigs(KafkaProperties kafkaProperties) {

		Map<String, Object> config = new HashMap<>();
		config.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		config.put(StreamsConfig.APPLICATION_ID_CONFIG, "app_id");
		config.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.String().getClass());
		config.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, UserSerde.class);
		return new KafkaStreamsConfiguration(config);
	}

	@Bean
	public KStream<String, UserEntity> kStream(StreamsBuilder kStreamBuilder) {
		KStream<String, UserEntity> stream = kStreamBuilder.stream(inputTopic);
		stream.mapValues(v -> {
			v.setCardNumber((long) (Math.random() * 10000));
			byte[] array = new byte[7]; // length is bounded by 7
			new Random().nextBytes(array);
			String generatedString = new String(array, Charset.forName("UTF-8"));
			v.setName(generatedString);

			System.out.println("Processing :: " + v);
			return v;
		}).to(outputTopic);

		/*
		 * stream.filter((k, v) -> v % 2 == 0).mapValues(v -> {
		 * System.out.println("Processing :: " + v); return v * v; }).to(outputTopic);
		 */
		return stream;
	}

}
