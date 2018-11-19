package com.person.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.person.springboot.pojo.User;
import com.person.springboot.service.ConsumerService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/consumer")
@Slf4j
public class ConsumerController {

	@Autowired
    private ConsumerService consumerService;

    /**
     * ����ȱʡ����
     * */
//    static {
//        BasicConfigurator.configure();
//    }

    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        User user = consumerService.findById(id).getBody();
        log.info("��ȡ�����û�idΪ {}, UserΪ {}", id, user);
        return user;
    }
}
