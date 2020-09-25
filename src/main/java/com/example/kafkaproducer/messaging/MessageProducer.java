package com.example.kafkaproducer.messaging;

import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

import com.example.kafkaproducer.model.Message;

public interface MessageProducer {

	ListenableFuture<SendResult<String, Message>> send(final String topic, final Message message);
}
