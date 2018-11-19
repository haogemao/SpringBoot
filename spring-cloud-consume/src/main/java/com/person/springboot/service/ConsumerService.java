package com.person.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.person.springboot.pojo.User;

@Service
public class ConsumerService {

	@Autowired
	private RestTemplate restTemplate;
	
	public ResponseEntity<User> findById(Long id) {
		return restTemplate.getForEntity("http://spring-cloud-producer/user/" + id, User.class);
	}
}
