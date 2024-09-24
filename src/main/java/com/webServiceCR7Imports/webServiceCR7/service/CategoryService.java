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

import com.webServiceCR7Imports.webServiceCR7.model.dto.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Category;

@Service
@FeignClient(name = "category", url = "http://localhost:8088/apicr7imports/private/category")
public interface CategoryService {


	@GetMapping
    List<Category> findAll();

	@GetMapping("/searchcategory?categoria")
	List<Category> findByName(@RequestParam("categoria") String name);

	@PostMapping
	Category save(@RequestBody CategoryRequest categoryRequest);
	
	@GetMapping("/{id}")
	Optional<Category> findOne(@PathVariable("id") Integer id);

	@DeleteMapping("/{id}")
	String delete(@PathVariable("id") Integer id);

	@PatchMapping(value = "/{id}")
	Category update(@PathVariable("id") Integer id, @RequestBody CategoryRequest categoryRequestUpdate);
	
	@GetMapping("/excel")
	byte[] getExcel();

}
