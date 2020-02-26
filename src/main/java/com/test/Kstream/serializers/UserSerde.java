package com.test.Kstream.serializers;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;
import com.test.Kstream.entities.UserEntity;

public class UserSerde implements Serde<UserEntity> {
	
	
	private JsonPOJOSerializer serializer=new JsonPOJOSerializer();
	private JsonPOJODeserializer deserializer= new JsonPOJODeserializer();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	
		serializer.configure(configs, isKey);
		deserializer.configure(configs, isKey);
	}

	@Override
	public Serializer<UserEntity> serializer() {
		// TODO Auto-generated method stub
		return serializer;
	}

	@Override
	public Deserializer<UserEntity> deserializer() {
		// TODO Auto-generated method stub
		return deserializer;
	}

	@Override
	public void close() {
			serializer.close();
			deserializer.close();
		
	}
	

}
