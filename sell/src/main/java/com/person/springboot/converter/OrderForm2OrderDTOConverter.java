package com.person.springboot.converter;

import com.google.gson.reflect.TypeToken;
import com.person.springboot.dto.CartDTO;
import com.person.springboot.dto.OrderDTO;
import com.person.springboot.entities.OrderDetail;
import com.person.springboot.enums.ResultEnum;
import com.person.springboot.exceptions.SellException;
import com.person.springboot.form.OrderForm;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderForm2OrderDTOConverter {

    public static OrderDTO convert(OrderForm orderForm){
        Gson gson = new Gson();
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());
        orderDTO.setBuyerPhone(orderForm.getPhone());

        List<OrderDetail> orderDetails = new ArrayList<OrderDetail>();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>(){}.getType());
        }catch (Exception e){
            log.error("【对象转换】错误，string={}", orderForm.getItems());
            throw new SellException(ResultEnum.PARAM_ERROR);
        }
        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }
}
