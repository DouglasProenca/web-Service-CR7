package com.webServiceCR7Imports.webServiceCR7.controller;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.enums.CategoryTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.model.request.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.service.CategoryService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/category")
public class CategoryController {
	
	private final CategoryService categoryService;

	@GetMapping
	public String categoryList(Model model) {
		model.addAttribute("categoryList", categoryService.findAll());
		return CategoryTemplateshttp.PAINEL.toString();
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("category") String nomeMarca, Model model) throws Exception {
		model.addAttribute("categoryList", categoryService.findByName(nomeMarca));
		return CategoryTemplateshttp.PAINEL.toString();
	}
	
	@GetMapping("/form")
	public String form(CategoryRequest category,Model model) {
		model.addAttribute("category", new CategoryRequest());
		model.addAttribute("tipo",0);
		return CategoryTemplateshttp.REGISTER.toString();
	}
	
	@PostMapping("/newCategory")
	public String newCategory(CategoryRequest category) {
		categoryService.save(category);
		return CategoryTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/{id}")
	public String formUpdateCategory(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("category", categoryService.findOne(id).get());
		model.addAttribute("categoryId", id);
		return CategoryTemplateshttp.REGISTER.toString();
	}
	
	@PostMapping("/{id}/editCategory")
	public String update(@PathVariable Integer id, CategoryRequest category) throws Exception {
		categoryService.update(id, category);
		return CategoryTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Integer id) {
		categoryService.delete(id);	
		return CategoryTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "categorys.xlsx");
		return new ResponseEntity<>(categoryService.getExcel(), headers, HttpStatus.OK);
	}
}
