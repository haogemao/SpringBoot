package com.person.springboot.constans;

public interface RedisConstans {

    /**
     * token前缀
     */
    String TOKEN_PREFIX = "token_%s";

    /**
     * 过期时间,单位秒
     */
    Integer EXPIPE = 300;
}
