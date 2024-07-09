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

import com.webServiceCR7Imports.webServiceCR7.dto.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.CategoryRequestUpdate;
import com.webServiceCR7Imports.webServiceCR7.model.Category;

@FeignClient(name = "category", url = "http://localhost:8088/apicr7imports/private/category")
public interface CategoryRepository {

	@GetMapping
    List<Category> findAll();
	
	@GetMapping("/searchcategory?categoria")
	List<Category> findByName(@RequestParam("categoria") String name);
	
	@PostMapping
	CategoryRequest saveCategory(@RequestBody CategoryRequest categoryRequest);
	
	@GetMapping("/{id}")
	Optional<Category> findById(@PathVariable("id") int id);
	
	@GetMapping("/excel")
	byte[] getExcel();
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable("id") int id);
	
	@PutMapping
	CategoryRequestUpdate updateCategory(CategoryRequestUpdate categoryRequestUpdate);
}
