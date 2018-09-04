package com.peron.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.peron.springboot.entities.Users;
import com.peron.springboot.service.UserService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringTransactionApplicationTests {
	
	@Autowired
	private UserService userService;

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void TestSave() {
		Users user = new Users(1,"张三", "123456");
		UserService userService = new UserService();
		userService.saveUser(user);
	}

}
