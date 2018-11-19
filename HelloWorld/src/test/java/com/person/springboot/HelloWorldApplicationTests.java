package com.person.springboot;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.person.springboot.controller.SpringBootProperties;
import com.person.springboot.controller.TestController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HelloWorldApplicationTests {

    private MockMvc mvc;

    @Autowired
    private SpringBootProperties springBootProperties;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new TestController()).build();
    }

    @Test
    public void getTest() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/HelloWorld").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk()).andExpect(content().string(equalTo("HelloWorld")));
    }

    @Test
    public void testProperties() throws Exception {
        Assert.assertEquals(springBootProperties.getName(), "苦逼的程序猿");
        Assert.assertEquals(springBootProperties.getTitle(), "Spring Boot Demo");
    }

    @Test
    public void contextLoads() {
    }

}
