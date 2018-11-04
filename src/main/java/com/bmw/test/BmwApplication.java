package com.bmw.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.bmw.test.config.AuthenticationFilter;



/** 
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
@EnableAutoConfiguration
@SpringBootApplication
public class BmwApplication {
	
	
	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		return new FilterRegistrationBean(new AuthenticationFilter());
	}

	public static void main(String[] args) {
		SpringApplication.run(BmwApplication.class, args);
	}
}
