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

import com.webServiceCR7Imports.webServiceCR7.enums.BrandTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.model.request.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.service.BrandService;
import com.webServiceCR7Imports.webServiceCR7.service.CountryService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
@RequestMapping("/admin/brand")
public class BrandController {

	private final BrandService brandservice;
	private final CountryService countryService;

	
	@GetMapping
	public String brandsList(Model model) {
	    model.addAttribute("brandList", brandservice.findAll());
		return BrandTemplateshttp.PAINEL.toString();
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("brand") String brandName,Model model) throws Exception {
	    model.addAttribute("brandList", brandservice.findByName(brandName));
		return BrandTemplateshttp.PAINEL.toString();
	}
	
	@GetMapping("/form")
	public String form(Model model) {
		model.addAttribute("brand", new BrandRequest());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("tipo",0);
		return BrandTemplateshttp.REGISTER.toString();
	}
	
	@PostMapping("/newBrand")
	public String newBrand(BrandRequest brand) {
		brandservice.save(brand);
		return BrandTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/{id}")
	public String formUpdateBrand(@PathVariable Integer id, Model model) throws Exception {
		model.addAttribute("brand", new BrandRequest(brandservice.findOne(id)));
		model.addAttribute("id", id);
		model.addAttribute("countriesList", countryService.findAll());
		return BrandTemplateshttp.REGISTER.toString();		
	}
	
	@PostMapping("/{id}/editBrand")
	public String editBrand(@PathVariable Integer id, BrandRequest brand) throws Exception {
		brandservice.update(id, brand);
		return BrandTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrand(@PathVariable Integer id) {
		brandservice.deleteById(id);
		return BrandTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
	 	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "brands.xlsx");
		return new ResponseEntity<>(brandservice.getExcel(), headers, HttpStatus.OK);
	}
}
