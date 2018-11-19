package com.person.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.springboot.pojo.User;
import com.person.springboot.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping(value="/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
    private User findById(@PathVariable Long id) {
        User user = userService.findUserById(id);
        log.info("This is the first server!");
        log.info("获取用户id为 {} 的用户，详细信息为 {}", id, user);
        return user;
    }
}
