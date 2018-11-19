package com.person.springboot.security;

import com.person.springboot.constans.CookieConstant;
import com.person.springboot.utils.CookieUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;

//@EnableWebMvc
//@Configuration
public class WebSecurityConfig implements WebMvcConfigurer {

    @Bean
    public SecurityInterceptor getSecurityInterceptor() {
        return new SecurityInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(getSecurityInterceptor());
        // 排除配置
        interceptorRegistration.excludePathPatterns(Arrays.asList("/sell/seller/", "/sell/seller/login", "/sell/seller/logout"));

        //拦截配置
        interceptorRegistration.addPathPatterns("/sell/**");

//        super.addInterceptors(registry);
    }

//    public void addInterceptors(InterceptorRegistry registry){
//        InterceptorRegistration interceptorRegistration = registry.addInterceptor(getSecurityInterceptor());
//
//        // 排除配置
//        interceptorRegistration.excludePathPatterns(Arrays.asList("/sell/seller/","/sell/seller/login","/sell/seller/logout"));
//
//        //拦截配置
//        interceptorRegistration.addPathPatterns("/sell/**");
//    }
}

class SecurityInterceptor extends HandlerInterceptorAdapter {

    /**
     * This implementation always returns {@code true}.
     *
     * @param request
     * @param response
     * @param handler
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Cookie cookie = CookieUtil.get(request, CookieConstant.TOKEN);
        if (cookie == null) {
            //跳转登录
            String url = "/sell/seller/";
            response.sendRedirect(url);
            return false;
        }
        return true;
    }
}
