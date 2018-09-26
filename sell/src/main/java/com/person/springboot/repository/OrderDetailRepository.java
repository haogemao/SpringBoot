package com.person.springboot.repository;

import com.person.springboot.entities.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, String> {
    public List<OrderDetail> findByOrderId(String orderId);
}
