package com.person.springboot.remote;

import org.springframework.stereotype.Component;

@Component
public class HelloRemoteHystrix implements HelloRemote {

	@Override
	public String index(String name) {
		// TODO Auto-generated method stub
		return "this service is unvariable";
	}

}
