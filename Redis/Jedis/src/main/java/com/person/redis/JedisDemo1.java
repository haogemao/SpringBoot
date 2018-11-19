package com.person.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;

public class JedisDemo1 {

    public void demo1() {
        Jedis jedis = new Jedis("127.0.0.1", 6379);
        jedis.set("name", "测试");
        System.out.println(jedis.get("name"));
        jedis.close();
    }

    public void demo2() {
        //获得连接池的配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        //设置最大连接数
        jedisPoolConfig.setMaxTotal(10);
        //设置最大空闲连接数
        jedisPoolConfig.setMaxIdle(5);

        //获得连接池
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "127.0.0.1", 6379);

        Jedis jedis = null;

        try {
            jedis = jedisPool.getResource();
            jedis.set("name", "测试");
            System.out.println(jedis.get("name"));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            jedis.close();
        }
    }

    public static void main(String[] args) {
        JedisDemo1 jedisDemo1 = new JedisDemo1();
        jedisDemo1.demo1();
        jedisDemo1.demo2();
    }
}
