package com.peron.springboot.mapper;

import org.springframework.data.jpa.repository.JpaRepository;

import com.peron.springboot.entities.Users;

public interface UserInfoRepository extends JpaRepository<Users, Integer> {

}
