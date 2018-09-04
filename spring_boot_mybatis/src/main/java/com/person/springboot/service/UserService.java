package com.person.springboot.service;

import java.util.List;

import com.person.springboot.entity.User;

public interface UserService {

	List<User> getUser();
	
	void addUser(User user);
	
	void updateUser(User user);
	
	int delUser(Integer id);
}
