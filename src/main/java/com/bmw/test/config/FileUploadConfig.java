package com.bmw.test.config;

import javax.servlet.MultipartConfigElement;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * Author:  yutao.liu
 * Email:   coco8509@sina.com
 * Created on:   Nov 4, 2018
 *
 */
@Configuration
public class FileUploadConfig {
	
	/**
	 * 
	 * @param maxFileSize
	 * @param maxRequestSize
	 * @return
	 */
	@Bean
	public MultipartConfigElement multipartConfigElement(
			@Value("${multipart.maxFileSize}") String maxFileSize,
			@Value("${multipart.maxRequestSize}") String maxRequestSize) {
		MultipartConfigFactory factory = new MultipartConfigFactory();		
		factory.setMaxFileSize(maxFileSize);		
		factory.setMaxRequestSize(maxRequestSize);
		return factory.createMultipartConfig();
	}
 
}