package com.example.producer.messaging;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.example.producer.model.Message;

public interface MessageProducer {

	ListenableFuture<SendResult<String, Message>> send(final String topic, final Message message);
}
