package com.test.Kstream.config;

import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.kstream.KStream;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import com.test.Kstream.entities.UserEntity;

public interface StreamConfigI {

	KafkaStreamsConfiguration kStreamsConfigs(KafkaProperties kafkaProperties);

	KStream<String, UserEntity> kStream(StreamsBuilder kStreamBuilder);

}