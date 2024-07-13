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
	
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("product") String productName,Model model, Principal principal) throws Exception {
	    return productService.getSearchProducts(productName, model, principal);
	}
	
	@GetMapping("/form/{totalPages}")
	public String form(Product product,Model model,@PathVariable Integer totalPages) {
		return productService.getForm(product, model,totalPages);
	}
	
	@PostMapping("/newProduct/{totalPages}")
	public String newProduct(ProductRequest product, Principal principal,@PathVariable Integer totalPages) {
		return productService.save(product,principal, totalPages);
	}
	
	@GetMapping("/{id}/{page}")
	public String formUpdateBrand(@PathVariable Integer id, @PathVariable Integer page, Principal principal, Model model) throws Exception {
		return productService.getFormUpdateProduct(id,page, principal, model);	
	}
	
	@PostMapping("/{id}/statusproduct/{page}")
	public String statusProduct(@PathVariable Integer id,@PathVariable Integer page, Principal principal) throws Exception {
		return productService.alterStatus(id, principal,page);	
	}
	
	@PostMapping("/{id}/editProduct/{page}")
	public String editBrand(@PathVariable Integer id,@PathVariable Integer page, Principal principal, Product product) throws Exception {
		return productService.update(id, page, product, principal);
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


