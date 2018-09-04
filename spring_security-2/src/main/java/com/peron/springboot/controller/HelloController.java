package com.peron.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloController {

	@RequestMapping(value="/index")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value="/hello")
	public String hello() {
		return "hello";
	}
	
	@RequestMapping(value="/logout")
	public String logout() {
		return "index";
	}
	
	@RequestMapping(value="/login")
	public String login() {
		return "login";
	}
}
