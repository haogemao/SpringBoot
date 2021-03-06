package com.person.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.person.springboot.mapper.UserInfoRepository;
import com.person.springboot.pojo.UserInfo;

@RestController
public class UserInfoController {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @GetMapping("/hello")
    public String hello() {
        return "hello";
    }

    @GetMapping("/UserlistByUserName")
    public List<UserInfo> getUserByUserName(@RequestParam(value = "username") String username) {
        return userInfoRepository.findByUsername(username);
//		return userInfoRepository.findByUsername(username);
    }

    @GetMapping("/Userlist")
    public List<UserInfo> getUserList() {
        return userInfoRepository.findAll();
    }

    @PostMapping("/addUser")
    public UserInfo addUser(@RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return userInfoRepository.save(userInfo);
    }

    @PutMapping("/updUser/{id}")
    public UserInfo updateUser(@PathVariable(value = "id") Integer id, @RequestParam(value = "username") String username, @RequestParam(value = "password") String password) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfo.setUsername(username);
        userInfo.setPassword(password);
        return userInfoRepository.save(userInfo);
    }

    @DeleteMapping("delUser/{id}")
    public void delUser(@PathVariable(value = "id") Integer id) {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(id);
        userInfoRepository.delete(userInfo);
    }
}
