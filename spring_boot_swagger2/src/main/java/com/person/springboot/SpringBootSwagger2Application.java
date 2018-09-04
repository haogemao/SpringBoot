package com.person.springboot;

import java.nio.charset.Charset;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.StringHttpMessageConverter;

@SpringBootApplication
@Configuration
public class SpringBootSwagger2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootSwagger2Application.class, args);
	}
	
	/**
	 * 自定义消息装换器
	 * @return
	 */
	@Bean
	public StringHttpMessageConverter stringBttpMessageConverter() {
	 StringHttpMessageConverter converter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
	 return converter;
	}
}
