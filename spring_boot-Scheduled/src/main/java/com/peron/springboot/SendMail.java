package com.peron.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class SendMail {
	
	@Autowired
	private JavaMailSender mailSender;

	/**
	 * 每两分钟触发
	 */
	@Scheduled(cron="0 0/2 * * * * ")
	public void senMail() {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("507297824@qq.com");
		message.setTo("1246810048@qq.com");
		message.setSubject("测试springboot定时任务");
		message.setText("测试springboot定时任务");
		
		mailSender.send(message);
	}
}
