package com.person.springboot.controller;


import com.person.springboot.dto.OrderDTO;
import com.person.springboot.enums.ResultEnum;
import com.person.springboot.exceptions.SellException;
import com.person.springboot.service.impl.OrderServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/seller/order")
@Slf4j
public class SellerOrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10") Integer size,
                             Map<String, Object> map){
        PageRequest pageRequest = PageRequest.of(page - 1, size);
        Page<OrderDTO> orderDTOS = orderService.findList(pageRequest);
        map.put("orderDTOPage",orderDTOS);
        map.put("currentPage",page);
        map.put("size",size);
        log.info(String.valueOf(orderDTOS.getTotalPages()));
        return new ModelAndView("order/list",map);
    }

    @GetMapping("/cancel")
    public ModelAndView cancel(@RequestParam(value = "orderId") String orderId, Map<String, Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderDTO = orderService.cancel(orderDTO);
        }catch (SellException e){
            log.error("[卖家端取消订单] 发生异常,异常信息={}", e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg", ResultEnum.ORDER_CANEL_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }

    @GetMapping("/detail")
    public ModelAndView detail(@RequestParam(value = "orderId") String orderId, Map<String,Object> map){
        OrderDTO orderDTO = new OrderDTO();
        try {
            orderDTO = orderService.findOne(orderId);
        }catch (SellException e){
            log.error("[卖家端查询订单详情] 发生异常,异常信息={}", e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("orderDTO",orderDTO);
        return new ModelAndView("order/detail",map);
    }

    @GetMapping("/finish")
    public ModelAndView finish(@RequestParam(value = "orderId") String orderId, Map<String,Object> map){
        try {
            OrderDTO orderDTO = orderService.findOne(orderId);
            orderDTO = orderService.finish(orderDTO);
        }catch (SellException e){
            log.error("[卖家端完结订单] 发生异常,异常信息={}",e);
            map.put("msg",e.getMessage());
            map.put("url","/sell/seller/order/list");
            return new ModelAndView("common/error",map);
        }
        map.put("msg",ResultEnum.ORDER_FINISH_SUCCESS.getMessage());
        map.put("url","/sell/seller/order/list");
        return new ModelAndView("common/success",map);
    }
}
