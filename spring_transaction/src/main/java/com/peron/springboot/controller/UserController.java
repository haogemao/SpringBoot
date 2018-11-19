package com.peron.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.peron.springboot.entities.Users;
import com.peron.springboot.service.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/save")
    @ResponseBody
    public void saveUser(Users user) {
//		Users user = new Users("张三", "123456");
        userService.saveUser(user);
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "index";
    }
}
