package com.person.springboot.filter;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TokenFilter extends ZuulFilter {

	@Override
	public boolean shouldFilter() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public Object run() throws ZuulException {
		// TODO Auto-generated method stub
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		
		log.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());
		
		String token = request.getParameter("token");
		
		if (StringUtils.isNotBlank(token)) {
			context.setSendZuulResponse(true); //对请求进行路由
			context.setResponseStatusCode(200);
			context.set("isSuccess", true);
		} else {
			context.setSendZuulResponse(false); //不对其进行路由
			context.setResponseStatusCode(400);
			context.setResponseBody("token is empty");
			context.set("isSuccess", false);
		}
		
		return null;
	}

	@Override
	public String filterType() {
		// TODO Auto-generated method stub
		return "pre";
	}

	@Override
	public int filterOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

}
