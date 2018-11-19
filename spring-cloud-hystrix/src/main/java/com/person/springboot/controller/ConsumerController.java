package com.person.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.person.springboot.remote.HelloRemote;

@RestController
public class ConsumerController {

	@Autowired
	HelloRemote helloRemote;
	
	@GetMapping("/hello/{name}")
    public String index(@PathVariable("name") String name) {
        return helloRemote.index(name);
    }
}
