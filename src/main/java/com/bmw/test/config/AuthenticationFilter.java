package com.bmw.test.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
public class AuthenticationFilter implements Filter{
   
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String KEY=ApplicationContextProvider.getApplicationContext().getEnvironment().getProperty("HEADER_KEY");
		String VALUE=ApplicationContextProvider.getApplicationContext().getEnvironment().getProperty("HEADER_VALUE");		 	
		HttpServletRequest req = (HttpServletRequest) request;	
		if(null !=req.getHeader(KEY) && req.getHeader(KEY).equals(VALUE)) {
			chain.doFilter(request, response);
		}		
	}

}
