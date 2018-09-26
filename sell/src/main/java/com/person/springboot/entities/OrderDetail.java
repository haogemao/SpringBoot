package com.person.springboot.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@Data
@DynamicUpdate
@DynamicInsert
@NoArgsConstructor
public class OrderDetail {

    @Id
    private String detailId;

    //订单ID
    private String orderId;

    //商品ID
    private String productId;

    //商品名称
    private String productName;

    //单价
    private BigDecimal productPrice;

    //商品数量
    private Integer productQuantity;

    //商品小图
    private String productIcon;
}
