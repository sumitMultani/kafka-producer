package com.example.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.producer.model.User;
import com.example.producer.service.UserService;

@RestController
public class MessageController {

	@Autowired
	private UserService service;
	
	@PostMapping("/user")
	public User sendUser(@RequestBody User user) {
		return service.sendUser(user);
	}
}
