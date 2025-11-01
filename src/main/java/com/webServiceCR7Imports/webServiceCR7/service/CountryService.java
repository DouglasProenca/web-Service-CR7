package com.webServiceCR7Imports.webServiceCR7.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.webServiceCR7Imports.webServiceCR7.model.response.CountryResponse;

@Service
@FeignClient(name = "country", url = "http://localhost:8888/apicr7imports/private/country")
public interface CountryService {
	
	@GetMapping
	List<CountryResponse> findAll();

}
