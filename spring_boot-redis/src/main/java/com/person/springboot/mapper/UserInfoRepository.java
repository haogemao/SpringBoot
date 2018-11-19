package com.person.springboot.mapper;

import java.util.List;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.person.springboot.entities.UserInfo;

@CacheConfig(cacheNames = "userInfo")
public interface UserInfoRepository extends JpaRepository<UserInfo, Integer> {

    @Cacheable(key = "#p0")
    public List<UserInfo> findByUsername(String username);

    @CachePut(key = "#p0.username")
    public UserInfo save(UserInfo userInfo);
}
