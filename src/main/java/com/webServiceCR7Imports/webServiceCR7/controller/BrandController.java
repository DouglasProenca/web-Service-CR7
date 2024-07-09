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

import com.webServiceCR7Imports.webServiceCR7.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Brand;
import com.webServiceCR7Imports.webServiceCR7.service.BrandService;


@Controller
@RequestMapping("/admin/brand")
public class BrandController {

	@Autowired
	BrandService brandservice;

	
	@GetMapping
	public String brandsList(Model model, Principal principal) {
	    return brandservice.getBrandsList(model, principal);
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("brand") String brandName,Model model, Principal principal) throws Exception {
	    return brandservice.getSearchBrands(brandName, model, principal);
	}
	
	@GetMapping("/form")
	public String form(Brand brand,Model model) {
		return brandservice.getForm(brand, model);
	}
	
	@PostMapping("/newBrand")
	public String newBrand(BrandRequest brand, Principal principal) {
		return brandservice.save(brand,principal);
	}
	
	@GetMapping("/{id}")
	public String formUpdateBrand(@PathVariable int id, Principal principal, Model model) throws Exception {
		return brandservice.getFormUpdateBrand(id, principal, model);	
	}
	
	@PostMapping("/{id}/editBrand")
	public String editBrand(@PathVariable int id, Principal principal, Brand brand) throws Exception {
		return brandservice.update(id, brand, principal);
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrand(@PathVariable int id, Principal principal) {
		return brandservice.delete(id);	
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
	    return brandservice.getExcel();
	}
}
