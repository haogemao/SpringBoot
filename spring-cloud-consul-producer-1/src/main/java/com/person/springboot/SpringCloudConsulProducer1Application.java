package com.person.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudConsulProducer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConsulProducer1Application.class, args);
	}
}
