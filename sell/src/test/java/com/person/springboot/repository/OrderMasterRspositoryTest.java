package com.person.springboot.repository;

import com.person.springboot.entities.OrderMaster;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.*;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRspositoryTest {

    @Autowired
    private OrderMasterRspository orderMasterRspository;

    private final String OPENID = "110112";

    @Test
    public void saveTest() {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setOrderId("123458");
        orderMaster.setBuyerName("师兄");
        orderMaster.setBuyerPhone("18710713067");
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerOpenid(OPENID);
        orderMaster.setOrderAmount(new BigDecimal(2.2));
        OrderMaster result = orderMasterRspository.save(orderMaster);
        Assert.assertNotNull(result);
    }

    @Test
    public void findByBuyerOpenid() {
        PageRequest pageRequest = PageRequest.of(0, 1);
        Page<OrderMaster> result = orderMasterRspository.findByBuyerOpenid(OPENID, pageRequest);
        Assert.assertNotEquals(0, result.getContent().size());
    }
}