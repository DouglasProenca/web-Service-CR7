package com.webServiceCR7Imports.webServiceCR7.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.dto.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Category;
import com.webServiceCR7Imports.webServiceCR7.service.CategoryService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	@Autowired
	CategoryService categoryService;

	
	@GetMapping
	public String brandsList(Model model, Principal principal) {
	    return categoryService.getCategorysList(model, principal);
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("category") String nomeMarca,Model model, Principal principal) throws Exception {
	    return categoryService.getSearchCategorys(nomeMarca, model, principal);
	}
	
	@GetMapping("/form")
	public String form(Category category,Model model) {
		return categoryService.getForm(category, model);
	}
	
	@PostMapping("/newCategory")
	public String newCategory(CategoryRequest category) {
		return categoryService.save(category);
	}
	
	@GetMapping("/{id}")
	public String formUpdateCategory(@PathVariable int id, Principal principal, Model model) throws Exception {
		return categoryService.getFormUpdateCategory(id, principal, model);	
	}
	
	@PostMapping("/{id}/editCategory")
	public String editBrand(@PathVariable int id, Category category) throws Exception {
		return categoryService.update(id, category);
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrand(@PathVariable int id, Principal principal) {
		return categoryService.delete(id);	
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
	    return categoryService.getExcel();
	}
}
