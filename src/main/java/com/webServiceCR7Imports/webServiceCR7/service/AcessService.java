package com.webServiceCR7Imports.webServiceCR7.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webServiceCR7Imports.webServiceCR7.model.request.AcessRequest;
import com.webServiceCR7Imports.webServiceCR7.model.response.AcessResponse;


@FeignClient(name = "acess", url = "http://localhost:8888/apicr7imports/acesso/login")
public interface AcessService {
	
	@PostMapping("/byrequestBody")
	AcessResponse login (@RequestBody AcessRequest acessRequest);
	
}
