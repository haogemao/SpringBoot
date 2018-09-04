package com.person.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.EventListener;

/**
 * 1.自定义监听事件，一般是继承ApplicationEvent抽象类
 * 2.自定义监听事件，一般是实现ApplicationListener接口
 * 3.启动的时候，需要把监听器加入到spring容器中
 * 4.发布事件，使用ConfigurableApplicationContext。publishEvent发布事件
 * 
 * 配置监听器
 * 1.SpringApplication。addListeners添加监听器
 * 2.把监听器纳入到spring容器中
 * 3.使用context.listener.classes配置配置项(详细内容见delegatingApplicationListener)
 * 4.使用@EventListener注解，在方法上面加入@EventListener注解，且该类必须纳入spring容器中管理(详细见：eventListenerMethodProcessor)
 * @author HS
 *
 */
@SpringBootApplication
public class SpringBootEventListenerApplication {

	public static void main(String[] args) {
		//SpringApplication.run(SpringBootEventListenerApplication.class, args);
		SpringApplication application = new SpringApplication(SpringBootEventListenerApplication.class);
		//监听事件
		application.addListeners(new MyApplicationListener());
		ConfigurableApplicationContext context = application.run(args);
		//发布事件
		context.publishEvent(new MyApplicationEvent(new Object()));
		context.close();
	}
}
