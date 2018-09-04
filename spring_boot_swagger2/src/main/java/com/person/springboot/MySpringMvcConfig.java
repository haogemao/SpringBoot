package com.person.springboot;

import java.nio.charset.Charset;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * 自定义拦截器
 * @author HS
 *
 */
@Configuration
public class MySpringMvcConfig extends WebMvcConfigurationSupport {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		HandlerInterceptor handlerInterceptor = new HandlerInterceptor() {
			@Override
			public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
					throws Exception {
				// TODO Auto-generated method stub
				System.out.println("自定义拦截器..........");
				return HandlerInterceptor.super.preHandle(request, response, handler);
			}
			@Override
			public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
					ModelAndView modelAndView) throws Exception {
				// TODO Auto-generated method stub
				HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
			}
			@Override
			public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
					Exception ex) throws Exception {
				// TODO Auto-generated method stub
				HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
			}
		};
		registry.addInterceptor(handlerInterceptor).addPathPatterns("/**");
		super.addInterceptors(registry);
	}
	
	/**
	 * 自定义消息装换器
	 */
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		StringHttpMessageConverter stringHttpMessageConverter = new StringHttpMessageConverter(Charset.forName("UTF-8"));
		converters.add(stringHttpMessageConverter);
		super.configureMessageConverters(converters);
	}

}
