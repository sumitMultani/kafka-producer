package com.example.producer.messaging.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;

import com.example.producer.messaging.MessageProducer;
import com.example.producer.model.Message;

@Component
public class KafkaMessageProducer implements MessageProducer{

	@Autowired
	private KafkaTemplate<String, Message> kafkaTemplate;
	
	@Override
	public ListenableFuture<SendResult<String, Message>> send(String topic, Message message) {
		ListenableFuture<SendResult<String, Message>> future = kafkaTemplate.send(topic, message);
		return future;
	}

}
