package com.person.springboot.aspect;

import com.person.springboot.constans.CookieConstant;
import com.person.springboot.constans.RedisConstans;
import com.person.springboot.exceptions.SellAuthorizeException;
import com.person.springboot.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

@Component
@Aspect
@Slf4j
public class SellerAuthorizeAspect {

    @Autowired
    private RedisTemplate redisTemplate;

    @Pointcut("execution(public * com.person.springboot.controller.*.*(..))" + "&& !execution(public * com.person.springboot.controller.SellerUserController.*(..))")
    public void verify() {
    }

    @Before("verify()")
    public void doVerify() {
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest httpServletRequest = servletRequestAttributes.getRequest();
        Cookie cookie = CookieUtil.get(httpServletRequest, CookieConstant.TOKEN);
        if (cookie == null) {
            log.warn("[登录校验] Cookie中查不到token");
//            return new ModelAndView("redirect:" + "/seller/");
            throw new SellAuthorizeException("session已过期", 1001);
        }

        String tokenValue = String.valueOf(redisTemplate.opsForValue().get(String.format(RedisConstans.TOKEN_PREFIX, cookie.getValue())));
        if (StringUtils.isEmpty(tokenValue)) {
            log.warn("[登录校验] Redis中查不到token");
            throw new SellAuthorizeException("session已过期", 1001);
//            return new ModelAndView("/sell/seller/");
        }
//        return new ModelAndView("/sell/seller/order/list");
    }
}
