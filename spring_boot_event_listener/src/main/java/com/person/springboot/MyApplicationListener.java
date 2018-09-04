package com.person.springboot;

import org.springframework.context.ApplicationListener;

public class MyApplicationListener implements ApplicationListener<MyApplicationEvent> {

	@Override
	public void onApplicationEvent(MyApplicationEvent event) {
		// TODO Auto-generated method stub
		System.out.println("接收到事件：" + event.toString());
	}

}