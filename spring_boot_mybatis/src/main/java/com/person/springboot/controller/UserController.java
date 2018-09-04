package com.person.springboot.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.person.springboot.entity.User;
import com.person.springboot.service.UserService;

@RestController
public class UserController {

	@Resource
	private UserService userService;

	@GetMapping("/showUser")
	public List<User> getUser() {
		List<User> user = this.userService.getUser();
		return user;
	}

	@PostMapping(value = "/addUser")
	public void addUser(@RequestParam("username") String username, @RequestParam("password") String password,
			@RequestParam("age") Integer age) {
		User user = new User();
		user.setUserName(username);
		user.setPassword(password);
		user.setAge(age);
		userService.addUser(user);
	}

	@PutMapping(value = "updUser/{id}")
	public void updUser(@PathVariable("id") Integer id, @RequestParam("username") String username,
			@RequestParam("password") String password, @RequestParam("age") Integer age) {
		User user = new User();
		user.setId(id);
		user.setUserName(username);
		user.setPassword(password);
		user.setAge(age);
		userService.updateUser(user);

	}

	@DeleteMapping(value = "delUser/{id}")
	public void delUser(@PathVariable("id") Integer id) {
		userService.delUser(id);
	}
}
