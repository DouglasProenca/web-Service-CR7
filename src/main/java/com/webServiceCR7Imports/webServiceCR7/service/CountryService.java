package com.webServiceCR7Imports.webServiceCR7.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.webServiceCR7Imports.webServiceCR7.model.Country;

@Service
@FeignClient(name = "country", url = "http://localhost:8088/apicr7imports/private/country")
public interface CountryService {
	
	@GetMapping
	List<Country> findAll();

}
