package com.webServiceCR7Imports.webServiceCR7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import feign.RequestInterceptor;

@Configuration
public class FeignConfig {
	
	private String token;

	@Bean
	RequestInterceptor requestInterceptor() {
		return requestTemplate -> {
			String token = "Bearer " + getToken();
			requestTemplate.header("Authorization", token);
		};
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
