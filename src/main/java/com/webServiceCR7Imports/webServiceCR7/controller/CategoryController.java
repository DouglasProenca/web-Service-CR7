package com.webServiceCR7Imports.webServiceCR7.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.webServiceCR7Imports.webServiceCR7.model.dto.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.service.CategoryService;
import com.webServiceCR7Imports.webServiceCR7.service.UsuarioService;

@Controller
@RequestMapping("/admin/category")
public class CategoryController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	CategoryService categoryService;

	
	@GetMapping
	public String categoryList(Model model, Principal principal) {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		model.addAttribute("categoryList", categoryService.findAll());
		return CategoryTemplateshttp.painel.getAdress();
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("category") String nomeMarca,Model model, Principal principal) throws Exception {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		model.addAttribute("categoryList", categoryService.findByName(nomeMarca));
		return CategoryTemplateshttp.painel.getAdress();
	}
	
	@GetMapping("/form")
	public String form(CategoryRequest category,Model model) {
		model.addAttribute("category", new CategoryRequest());
		model.addAttribute("tipo",0);
		return CategoryTemplateshttp.registrer.getAdress();
	}
	
	@PostMapping("/newCategory")
	public String newCategory(CategoryRequest category) {
		categoryService.save(category);
		return CategoryTemplateshttp.redirect.getAdress();
	}
	
	@GetMapping("/{id}")
	public String formUpdateCategory(@PathVariable Integer id, Principal principal, Model model) throws Exception {
		model.addAttribute("category", new CategoryRequest(categoryService.findOne(id).get()));
		model.addAttribute("categoryId", id);
		return CategoryTemplateshttp.registrer.getAdress();
	}
	
	@PostMapping("/{id}/editCategory")
	public String update(@PathVariable Integer id, CategoryRequest category) throws Exception {
		categoryService.update(id, category);
		return CategoryTemplateshttp.redirect.getAdress();
	}
	
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable Integer id, Principal principal) {
		categoryService.delete(id);	
		return CategoryTemplateshttp.redirect.getAdress();
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "categorys.xlsx");
		return new ResponseEntity<>(categoryService.getExcel(), headers, HttpStatus.OK);
	}
}
