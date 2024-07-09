package com.webServiceCR7Imports.webServiceCR7.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.BrandRequestUpdate;
import com.webServiceCR7Imports.webServiceCR7.model.Brand;


@FeignClient(name = "brand", url = "http://localhost:8088/apicr7imports/private/brand")
public interface BrandRepository {

	@GetMapping
    List<Brand> findAll();
	
	@GetMapping("/searchbrand?marca")
	List<Brand> findByName(@RequestParam("marca") String name);
	
	@PostMapping
	BrandRequest saveBrand(@RequestBody BrandRequest brandRequest);
	
	@GetMapping("/{id}")
	Optional<Brand> findById(@PathVariable("id") int id);
	
	@GetMapping("/excel")
	byte[] getExcel();
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable("id") int id);
	
	@PutMapping
	BrandRequestUpdate updateBrand(BrandRequestUpdate brandRequestUpdate);

}
