package com.person.springboot.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.person.springboot.dao.UserDao;
import com.person.springboot.entity.User;
import com.person.springboot.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	@Resource
	private UserDao userDao;

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public void addUser(User user) {
		// TODO Auto-generated method stub
		userDao.addUser(user);
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userDao.updUser(user);
	}

	@Override
	public int delUser(Integer id) {
		// TODO Auto-generated method stub
		return userDao.delUser(id);
	}

}
