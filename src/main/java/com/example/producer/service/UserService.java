package com.example.producer.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.producer.messaging.MessageProducer;
import com.example.producer.model.User;

@Service
public class UserService {

	@Autowired
	private MessageProducer messageProducer;
	
	private static final String TOPIC = "MyTopic";

	public User sendUser(User user) {
		user.setTimeCreate(Instant.now());
		messageProducer.send(TOPIC, user);
		return user;
	}

}
