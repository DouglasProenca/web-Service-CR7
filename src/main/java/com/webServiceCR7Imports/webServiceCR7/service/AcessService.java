package com.webServiceCR7Imports.webServiceCR7.service;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webServiceCR7Imports.webServiceCR7.model.dto.AcessRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Acess;


@FeignClient(name = "acess", url = "http://localhost:8088/apicr7imports/acesso/login")
public interface AcessService {
	
	@PostMapping("/byrequestBody")
	Acess login (@RequestBody AcessRequest acessRequest);
}
