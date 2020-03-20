package com.test.Kstream.serializers;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;

public class JsonPOJODeserializer implements Deserializer<BankingInfosDto> {

	//private ObjectMapper objectMapper = new ObjectMapper();
	static private Gson gson = new Gson();
	private static final Charset CHARSET = StandardCharsets.UTF_8;

	

	JsonPOJODeserializer() {
	}

	@Override
	public void configure(Map<String, ?> props, boolean isKey) {
		
	}

	@Override
	public BankingInfosDto deserialize(String topic, byte[] bytes) {
		// TODO Auto-generated method stub

		if (bytes == null)
            return null;

		
        try {
        	String User = new String(bytes, CHARSET);
        	System.out.println(User);
            return gson.fromJson(User, BankingInfosDto.class);

        } catch (Exception e) {
            throw new SerializationException(e);
        }

     
	}

	@Override
	public void close() {
		
	}

	

}
