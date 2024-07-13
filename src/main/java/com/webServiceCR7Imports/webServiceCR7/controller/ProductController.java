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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.webServiceCR7Imports.webServiceCR7.dto.ProductRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Product;
import com.webServiceCR7Imports.webServiceCR7.service.ProductService;


@Controller
@RequestMapping("admin/product")
public class ProductController {
	
	@Autowired
	ProductService productService;

	
	@GetMapping("/list/{page}")
	public String productsList(Model model, Principal principal,@PathVariable Integer page,Integer limit) {
	    return productService.getProductsList(model, principal,page,limit);
	}
	
	@GetMapping("/teste")
	public String teste(Model model, Principal principal,Integer page,Integer limit) throws JsonMappingException, JsonProcessingException {
	    return productService.getProductsList(model, principal,page,limit);
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("product") String productName,Model model, Principal principal) throws Exception {
	    return productService.getSearchProducts(productName, model, principal);
	}
	
	@GetMapping("/form")
	public String form(Product product,Model model) {
		return productService.getForm(product, model);
	}
	
	@PostMapping("/newProduct")
	public String newProduct(ProductRequest product, Principal principal) {
		return productService.save(product,principal);
	}
	
	@GetMapping("/{id}")
	public String formUpdateBrand(@PathVariable int id, Principal principal, Model model) throws Exception {
		return productService.getFormUpdateProduct(id, principal, model);	
	}
	
	@PostMapping("/{id}/statusproduct/{page}")
	public String statusProduct(@PathVariable Integer id,@PathVariable Integer page, Principal principal) throws Exception {
		return productService.alterStatus(id, principal,page);	
	}
	
	@PostMapping("/{id}/editProduct")
	public String editBrand(@PathVariable int id, Principal principal, Product product) throws Exception {
		return productService.update(id, product, principal);
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrand(@PathVariable int id, Principal principal) {
		return productService.delete(id);	
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
	    return productService.getExcel();
	}
	
}


