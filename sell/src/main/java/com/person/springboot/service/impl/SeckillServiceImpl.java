package com.person.springboot.service.impl;

import com.person.springboot.exceptions.SellException;
import com.person.springboot.service.RedisLock;
import com.person.springboot.service.SeckillService;
import com.person.springboot.utils.KeyUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class SeckillServiceImpl implements SeckillService {

    @Autowired
    private RedisLock redisLock;

    private static final int TIMEOUT = 10*1000;//超时时间 10s

    /**
     * 活动，特价，限量100000份
     */
    static Map<String,Integer> products;//模拟商品信息表
    static Map<String,Integer> stock;//模拟库存表
    static Map<String,String> orders;//模拟下单成功用户表
    static {
        /**
         * 模拟多个表，商品信息表，库存表，秒杀成功订单表
         */
        products = new HashMap<>();
        stock = new HashMap<>();
        orders = new HashMap<>();
        products.put("123456",100000);
        stock.put("123456",100000);
    }

    private String queryMap(String productId){//模拟查询数据库
        return "国庆活动，皮蛋特教，限量"
                +products.get(productId)
                +"份,还剩:"+stock.get(productId)
                +"份,该商品成功下单用户数:"
                +orders.size()+"人";
    }

    /**
     * 查询特价商品
     *
     * @param productId
     * @return
     */
    @Override
    public String querySecKillProductInfo(String productId) {
        return queryMap(productId);
    }

    /**
     * 秒杀的逻辑方法
     *
     * @param productId
     */
    @Override
    public void orderProductMocckDiffUser(String productId) {
        //加锁
        long time = System.currentTimeMillis() + TIMEOUT;
        if (!redisLock.lock(productId,String.valueOf(TIMEOUT))){
            throw new SellException(101,"很抱歉，人太多了，换个姿势再试试~~");
        }

        int stockNum = stock.get(productId);
        if (stockNum == 0){
            throw new SellException(100,"活动已经结束了");
        }
        else{
            orders.put(KeyUtil.generateUniqueKey(),productId);
            stockNum = stockNum - 1;
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            stock.put(productId,stockNum);
        }

        redisLock.unlock(productId,String.valueOf(time));
    }
}
