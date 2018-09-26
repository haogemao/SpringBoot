package com.person.springboot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.person.springboot.entities.OrderDetail;
import com.person.springboot.enums.OrderStatusEnum;
import com.person.springboot.enums.PayStatusEnum;
import com.person.springboot.utils.EnumUtil;
import com.person.springboot.utils.serializer.Date2LongSerializer;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderDTO {

    //订单ID
    private String orderId;

    //买家名字
    private String buyerName;

    //买家手机号
    private String buyerPhone;

    //买家地址
    private String buyerAddress;

    //买家微信OpenId
    private String buyerOpenid;

    //订单总金额
    private BigDecimal orderAmount;

    /**
     * 订单状态, 默认0为新订单.
     */
    private Integer orderStatus = OrderStatusEnum.NEW.getCode();

    /**
     * 支付状态, 默认0为未支付.
     */
    private Integer payStatus = PayStatusEnum.WAIT.getCode();

    //时间处理
    @JsonSerialize(using = Date2LongSerializer.class)
    private Date createTime;

    @JsonSerialize(using = Date2LongSerializer.class)
    private Date updateTime;

    private List<OrderDetail> orderDetails;

    @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return (OrderStatusEnum) EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }

    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
