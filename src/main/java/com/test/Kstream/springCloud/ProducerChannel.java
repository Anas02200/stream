package com.test.Kstream.springCloud;


import org.apache.kafka.streams.kstream.KStream;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

import com.test.Kstream.entities.UserEntity;

public interface ProducerChannel {

	String rawuser = "user";
	String instream = "usersin";// page viewin
	String treateduser = "usersprocessed";// pagecount out
	String outstream = "outstream";

	@Output(rawuser)
	MessageChannel rawuser(); // pv out producer

	@Input(instream) // consumes users
	KStream<String, UserEntity> instream(); // pv in

	@Output(treateduser)
	KStream<String, UserEntity> treateduser(); // ouputs processed users pc out

	 @Input(outstream)
	 KStream<String, UserEntity> outstream();

}