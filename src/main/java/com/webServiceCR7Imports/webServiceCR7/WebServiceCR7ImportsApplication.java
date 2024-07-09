package com.webServiceCR7Imports.webServiceCR7;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class WebServiceCR7ImportsApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebServiceCR7ImportsApplication.class, args);
	}
}
