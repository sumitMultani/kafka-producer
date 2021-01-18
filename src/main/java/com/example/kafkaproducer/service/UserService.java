package com.example.kafkaproducer.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.kafkaproducer.messaging.MessageProducer;
import com.example.kafkaproducer.model.User;

@Service
public class UserService {

	@Autowired
	private MessageProducer messageProducer;
	
	private static final String TOPIC = "MyTopic";

// send users
	public User sendUser(User user) {
		user.setTimeCreate(Instant.now());
		messageProducer.send(TOPIC, user);
		return user;
	}

}
