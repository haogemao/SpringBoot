package com.person.springboot.mapper;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.pojo.UserInfo;

@CacheConfig(cacheNames = "user")
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    @Cacheable
    public List<UserInfo> findByUsername(String username);
}
