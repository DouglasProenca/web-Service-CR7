package com.webServiceCR7Imports.webServiceCR7.repository;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import com.webServiceCR7Imports.webServiceCR7.model.Country;

@FeignClient(name = "country", url = "http://localhost:8088/apicr7imports/private/country")
public interface CountryRepository {

	@GetMapping
	List<Country> retornaUsuario();

}
