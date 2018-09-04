package com.person.springboot.dao;

import java.util.List;

import com.person.springboot.entity.User;

public interface UserDao {

	List<User> findAll();

	void addUser(User user);

	void updUser(User user);

	int delUser(Integer id);
}
