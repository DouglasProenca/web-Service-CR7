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

import com.webServiceCR7Imports.webServiceCR7.enums.BrandTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.model.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.service.BrandService;
import com.webServiceCR7Imports.webServiceCR7.service.CountryService;
import com.webServiceCR7Imports.webServiceCR7.service.UsuarioService;


@Controller
@RequestMapping("/admin/brand")
public class BrandController {

	@Autowired
	BrandService brandservice;
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	CountryService countryService;

	
	@GetMapping
	public String brandsList(Model model, Principal principal) {
	    model.addAttribute("principal",usuarioService.findByEmail(principal.getName()));
	    model.addAttribute("brandList", brandservice.findAll());
		return BrandTemplateshttp.painel.getAdress();
	}
	
	@GetMapping("/find")
	public String searchBrands(@RequestParam("brand") String brandName,Model model, Principal principal) throws Exception {
	    model.addAttribute("principal",usuarioService.findByEmail(principal.getName()));
	    model.addAttribute("brandList", brandservice.findByName(brandName));
		return BrandTemplateshttp.painel.getAdress();
	}
	
	@GetMapping("/form")
	public String form(BrandRequest brand,Model model) {
		model.addAttribute("brand", new BrandRequest());
		model.addAttribute("countries", countryService.findAll());
		model.addAttribute("tipo",0);
		return BrandTemplateshttp.registrer.getAdress();
	}
	
	@PostMapping("/newBrand")
	public String newBrand(BrandRequest brand, Principal principal) {
		brandservice.save(brand);
		return BrandTemplateshttp.redirect.getAdress();
	}
	
	@GetMapping("/{id}")
	public String formUpdateBrand(@PathVariable Integer id, Principal principal, Model model) throws Exception {
		model.addAttribute("brand", new BrandRequest(brandservice.findOne(id)));
		model.addAttribute("id", id);
		model.addAttribute("countriesList", countryService.findAll());
		return BrandTemplateshttp.registrer.getAdress();		
	}
	
	@PostMapping("/{id}/editBrand")
	public String editBrand(@PathVariable Integer id, Principal principal, BrandRequest brand) throws Exception {
		brandservice.update(id, brand);
		return BrandTemplateshttp.redirect.getAdress();
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrand(@PathVariable Integer id, Principal principal) {
		brandservice.deleteById(id);
		return BrandTemplateshttp.redirect.getAdress();
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]>getExcel() {
	 	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "brands.xlsx");
		return new ResponseEntity<>(brandservice.getExcel(), headers, HttpStatus.OK);
	}
}
