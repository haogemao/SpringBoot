package com.person.springboot.service;

import com.person.springboot.entities.SellerInfo;

public interface SellerService {

    public SellerInfo findByOpenid(String openid);
}
