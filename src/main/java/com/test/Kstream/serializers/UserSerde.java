package com.test.Kstream.serializers;

import java.util.Map;

import com.test.Kstream.dataTransferObject.BankingInfosDto;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serde;
import org.apache.kafka.common.serialization.Serializer;

public class UserSerde implements Serde<BankingInfosDto> {
	
	
	private JsonPOJOSerializer serializer=new JsonPOJOSerializer();
	private JsonPOJODeserializer deserializer= new JsonPOJODeserializer();

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	
		serializer.configure(configs, isKey);
		deserializer.configure(configs, isKey);
	}

	@Override
	public Serializer<BankingInfosDto> serializer() {
		// TODO Auto-generated method stub
		return serializer;
	}

	@Override
	public Deserializer<BankingInfosDto> deserializer() {
		// TODO Auto-generated method stub
		return deserializer;
	}

	@Override
	public void close() {
			serializer.close();
			deserializer.close();
		
	}
	

}
