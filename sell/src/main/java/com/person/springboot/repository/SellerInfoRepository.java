package com.person.springboot.repository;

import com.person.springboot.entities.SellerInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SellerInfoRepository extends JpaRepository<SellerInfo,String> {

    public SellerInfo findByOpenid(String openId);
}
