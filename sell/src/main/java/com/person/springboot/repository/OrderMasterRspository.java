package com.person.springboot.repository;

import com.person.springboot.entities.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderMasterRspository extends JpaRepository<OrderMaster, String> {

    public Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);
}
