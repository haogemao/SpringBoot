package com.person.springboot.controller;

import com.person.springboot.config.ProjectUrlConfig;
import com.person.springboot.constans.CookieConstant;
import com.person.springboot.constans.RedisConstans;
import com.person.springboot.entities.SellerInfo;
import com.person.springboot.enums.ResultEnum;
import com.person.springboot.form.LoginForm;
import com.person.springboot.service.impl.SellerServiceImpl;
import com.person.springboot.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Controller
@RequestMapping("/seller")
@Slf4j
public class SellerUserController {

    @Autowired
    private SellerServiceImpl sellerService;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private ProjectUrlConfig projectUrlConfig;

    @GetMapping("/")
//    public  ModelAndView index(){
//        return new ModelAndView("login/login");
//    }
    public String index(){
        return "login/login";
    }

    @PostMapping("/login")
    public ModelAndView login(@Valid LoginForm loginForm, BindingResult bindingResult,
                              HttpServletResponse httpServletResponse,
                              Map<String, Object> map){
        if (bindingResult.hasErrors()){
            log.error("登录，发生错误 = {}",bindingResult.getFieldError().getDefaultMessage());
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url","/sell/seller/");
            return new ModelAndView("common/error",map);
        }
        //1.openid去和数据库里的数据匹配
        SellerInfo sellerInfo = sellerService.findByOpenid(loginForm.getOpenid());
        if (sellerInfo == null){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/seller/");
            return new ModelAndView("common/error",map);
        }

        if (!loginForm.getPassword().equals(sellerInfo.getPassword())){
            map.put("msg", ResultEnum.LOGIN_FAIL.getMessage());
            map.put("url","/sell/seller/");
            return new ModelAndView("common/error",map);
        }

        //2.设置token至Redis
        //stringRedisTemplate.opsForValue().set("abc","122");//操作某些value 写入key-value
        String token = UUID.randomUUID().toString();
        log.info(loginForm.getOpenid());
        redisTemplate.opsForValue().set(String.format(RedisConstans.TOKEN_PREFIX,token),loginForm.getOpenid(),RedisConstans.EXPIPE, TimeUnit.SECONDS);
        //key,value,过期时间,时间单位 s

        //3.设置token至cookie
        CookieUtil.set(httpServletResponse,CookieConstant.TOKEN,token,CookieConstant.EXPIPE);

        //做一个跳转获取订单列表后再跳转 重定向不要带项目名 - 最好带绝对地址 也就是带http://的绝对地址
        return new ModelAndView("redirect:" + projectUrlConfig.getProject() + "/sell/seller/order/list");
    }

    @GetMapping("/logout")
    public ModelAndView logout(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,Map<String, Object> map){
        //1.从Cookie查询
        Cookie cookie = CookieUtil.get(httpServletRequest,CookieConstant.TOKEN);

        if (cookie != null){
            //2.清除redis
            redisTemplate.opsForValue().getOperations().delete(String.format(RedisConstans.TOKEN_PREFIX,cookie.getValue()));
            //3.清除cookie
            CookieUtil.del(httpServletResponse,CookieConstant.TOKEN);
        }
        map.put("msg",ResultEnum.LOGOUT_SUCCESS.getMessage());
        map.put("url","/sell/seller/");
        return new ModelAndView("common/success",map);
    }
}
