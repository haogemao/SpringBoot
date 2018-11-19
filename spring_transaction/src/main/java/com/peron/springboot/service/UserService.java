package com.peron.springboot.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.peron.springboot.entities.Users;
import com.peron.springboot.mapper.UserInfoRepository;

@Service
public class UserService {

    @Resource
    private UserInfoRepository userInfoRepository;

    public void saveUser(Users user) {
        userInfoRepository.save(user);
    }
}
