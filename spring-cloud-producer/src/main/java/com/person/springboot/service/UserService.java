package com.person.springboot.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.person.springboot.pojo.User;

@Service
public class UserService {
	
	private static Map<Long, User> users = new HashMap<Long, User>();
	
	static {
		users.put(1L, new User(1L, "xiaxuan", 24));
        users.put(2L, new User(2L, "bingwen", 24));
        users.put(3L, new User(3L, "bingsong", 24));
        users.put(4L, new User(4L, "bingrong", 24));
        users.put(5L, new User(5L, "bingwang", 24));
	}
	
	public User findUserById(Long id) {
		return users.get(id);
	}
}
