package com.person.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
/**
 * ��Spring Cloud Edgware��ʼ��@EnableDiscoveryClient ��@EnableEurekaClient ��ʡ�ԡ�ֻ����������������������Ӧ���ã����ɽ�΢����ע�ᵽ����������ϡ�
 * @author HS
 *
 */
@EnableDiscoveryClient
public class SpringCloudProducerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudProducerApplication.class, args);
	}
}
