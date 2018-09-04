package com.person.springboot.mapper;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.pojo.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {
	
	public List<UserInfo> findByUsername(String username);
}
