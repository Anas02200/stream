package com.test.Kstream.serializers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

import com.google.gson.Gson;
import com.test.Kstream.entities.UserEntity;

public class JsonPOJOSerializer implements Serializer<BankingInfosDto> {

	private static final Charset CHARSET = StandardCharsets.UTF_8;
	static private Gson gson = new Gson();

	JsonPOJOSerializer() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, BankingInfosDto data) {
		if (data == null)
			return null;

		try {
			String line = gson.toJson(data);
			return line.getBytes(CHARSET);
		} catch (Exception e) {
			throw new SerializationException("Error serializing JSON message", e);
		}
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		Serializer.super.close();
	}

}
