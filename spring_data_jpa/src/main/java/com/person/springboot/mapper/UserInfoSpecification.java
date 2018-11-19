package com.person.springboot.mapper;

import java.util.List;

import org.springframework.data.jpa.domain.Specification;

import com.person.springboot.pojo.UserInfo;

public interface UserInfoSpecification extends Specification<UserInfo> {

    public List<UserInfo> findByName(String userName);
}
