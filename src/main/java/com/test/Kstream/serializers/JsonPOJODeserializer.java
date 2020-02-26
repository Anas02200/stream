package com.test.Kstream.serializers;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

import com.google.gson.Gson;
import com.test.Kstream.entities.UserEntity;

public class JsonPOJODeserializer implements Deserializer<UserEntity> {

	//private ObjectMapper objectMapper = new ObjectMapper();
	static private Gson gson = new Gson();
	private static final Charset CHARSET = Charset.forName("UTF-8");

	

	public JsonPOJODeserializer() {
	}

	@Override
	public void configure(Map<String, ?> props, boolean isKey) {
		
	}

	@Override
	public UserEntity deserialize(String topic, byte[] bytes) {
		// TODO Auto-generated method stub
		if (bytes == null)
            return null;

		
        try {
        	String User = new String(bytes, CHARSET);
            return gson.fromJson(User, UserEntity.class);
        } catch (Exception e) {
            throw new SerializationException(e);
        }

     
	}

	@Override
	public void close() {
		
	}

	

}
