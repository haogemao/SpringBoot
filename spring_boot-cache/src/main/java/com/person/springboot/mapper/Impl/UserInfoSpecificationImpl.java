package com.person.springboot.mapper.Impl;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.person.springboot.mapper.UserInfoSpecification;
import com.person.springboot.pojo.UserInfo;

public class UserInfoSpecificationImpl implements UserInfoSpecification {

    @Override
    public Predicate toPredicate(Root<UserInfo> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public List<UserInfo> findByName(String userName) {
        // TODO Auto-generated method stub
        return null;
    }

}
