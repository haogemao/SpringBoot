package com.person.springboot;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import com.person.springboot.entities.UserInfo;
import com.person.springboot.mapper.UserInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
@EnableCaching
public class SpringBootRedisApplicationTests {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private CacheManager cacheManger;

    @Before
    public void before() {
        userInfoRepository.save(new UserInfo("AAA", "123456"));
    }

    @Test
    public void test() throws Exception {
        List u1 = new ArrayList();
        u1 = userInfoRepository.findByUsername("AAA");
        log.info("第一次查询： " + ((UserInfo) u1.get(0)).getPassword());

        List u2 = userInfoRepository.findByUsername("AAA");
        log.info("第二次查询： " + ((UserInfo) u2.get(0)).getPassword());

        ((UserInfo) u1.get(0)).setPassword("12345");
        userInfoRepository.save((UserInfo) u1.get(0));

        List u3 = userInfoRepository.findByUsername("AAA");
        log.info("第三次查询： " + ((UserInfo) u3.get(0)).getPassword());
    }

}
