package com.peron.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestCotroller {

	@RequestMapping("/")
	public String index() {
		return "Hello Security";
	}
}
