package com.spbd.core.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class AuthFilter implements Filter{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthFilter.class);


	@Override
	public void init(FilterConfig config) throws ServletException {
		
	}
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		ContentCachingRequestWrapper requestWrapper = new ContentCachingRequestWrapper((HttpServletRequest) request);
		String body = new String(requestWrapper.getBody(),request.getCharacterEncoding());
		LOGGER.info("request body is {}",body);
		//TODO 验证签名
		chain.doFilter(requestWrapper, response);
	}

	
	@Override
	public void destroy() {
		
	}
}
