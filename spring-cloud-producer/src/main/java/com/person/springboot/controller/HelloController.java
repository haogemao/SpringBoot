package com.person.springboot.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@GetMapping(value = "/hello")
	public String index(@RequestParam(value="name") String name) {
		return "hello "+name+"£¬this is first messge";
	}
}
