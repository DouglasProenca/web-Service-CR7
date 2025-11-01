package com.webServiceCR7Imports.webServiceCR7.service;

import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.model.request.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.model.response.CategoryResponse;

@Service
@FeignClient(name = "category", url = "http://localhost:8888/apicr7imports/private/category")
public interface CategoryService {


	@GetMapping
    List<CategoryResponse> findAll();

	@GetMapping("/searchcategory?categoria")
	List<CategoryResponse> findByName(@RequestParam("categoria") String name);

	@PostMapping
	CategoryResponse save(@RequestBody CategoryRequest categoryRequest);
	
	@GetMapping("/{id}")
	Optional<CategoryResponse> findOne(@PathVariable("id") Integer id);

	@DeleteMapping("/{id}")
	String delete(@PathVariable("id") Integer id);

	@PatchMapping(value = "/{id}")
	CategoryResponse update(@PathVariable("id") Integer id, @RequestBody CategoryRequest categoryRequestUpdate);
	
	@GetMapping("/excel")
	byte[] getExcel();

}
