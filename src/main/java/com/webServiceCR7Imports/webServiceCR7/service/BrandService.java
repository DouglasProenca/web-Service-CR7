package com.webServiceCR7Imports.webServiceCR7.service;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.model.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Brand;

@Service
@FeignClient(name = "brand", url = "http://localhost:8088/apicr7imports/private/brand")
public interface BrandService {

	@GetMapping
    List<Brand> findAll();

	@GetMapping("/searchbrand?marca")
	List<Brand> findByName(@RequestParam("marca") String name);
	

	@PostMapping
	Brand save(@RequestBody BrandRequest brandRequest);
	
	@GetMapping("/{id}")
	Brand findOne(@PathVariable("id") Integer id);
	

	@DeleteMapping("/{id}")
	void deleteById(@PathVariable("id") Integer id);

	@PatchMapping(value = "/{id}")
	Brand update(@PathVariable("id") Integer id, @RequestBody BrandRequest categoryRequestUpdate);
	
	@GetMapping("/excel")
	byte[] getExcel();

}
