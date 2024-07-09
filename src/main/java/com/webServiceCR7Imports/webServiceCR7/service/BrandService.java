package com.webServiceCR7Imports.webServiceCR7.service;

import java.security.Principal;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webServiceCR7Imports.webServiceCR7.Enum.BrandTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.BrandRequestUpdate;
import com.webServiceCR7Imports.webServiceCR7.model.Brand;
import com.webServiceCR7Imports.webServiceCR7.repository.BrandRepository;

@Service
public class BrandService {

	@Autowired
	BrandRepository repository;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	CountryService countryService;

	public List<Brand> findAll() {
		return repository.findAll();
	}

	public List<Brand> findByName(String name) {
		return repository.findByName(name);
	}

	public String save(BrandRequest brand, Principal principal) {
		int idUser = Integer.valueOf(String.valueOf(usuarioService.findByEmail(principal.getName()).getId()));
		repository.saveBrand(new BrandRequest(brand.getMarca(), brand.getCountry(), new Date(), idUser));
		return BrandTemplateshttp.redirect.getAdress();
	}

	public Brand findOne(int id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Marca não localizada"));
	}

	public String delete(int id) {
		repository.deleteById(id);
		return BrandTemplateshttp.redirect.getAdress();
	}

	public String update(int id, Brand brand,Principal principal) throws Exception {
		repository.findById(id).orElseThrow(() -> new Exception("Marca não localizada"));
		
		Integer idUser = Integer.valueOf(String.valueOf(usuarioService.findByEmail(principal.getName()).getId()));

		BrandRequestUpdate brandRequestUpdate = new BrandRequestUpdate();
		brandRequestUpdate.setId(id);
		brandRequestUpdate.setMarca(brand.getMarca());
		brandRequestUpdate.setCountry(brand.getCountry().getId());
		brandRequestUpdate.setData(new Date());
		brandRequestUpdate.setUser(idUser);
		
		
		repository.updateBrand(brandRequestUpdate);
		return BrandTemplateshttp.redirect.getAdress();
	}
	
	public ResponseEntity<byte[]> getExcel() {
	 	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "brands.xlsx");
		return new ResponseEntity<>(repository.getExcel(), headers, HttpStatus.OK);
	}
	
	public String getSearchBrands(String nomeMarca,Model model, Principal principal) throws Exception {
	    model.addAttribute("principal",usuarioService.findByEmail(principal.getName()));
	    model.addAttribute("brandList", findByName(nomeMarca));
		return BrandTemplateshttp.painel.getAdress();
	}
	
	public String getForm(Brand brand,Model model) {
		model.addAttribute("countries", countryService.findAll());
		return BrandTemplateshttp.registrer.getAdress();
	}
	
	public String getFormUpdateBrand(int id,Principal principal, Model model) throws Exception {
		model.addAttribute("brand", findOne(id));
		model.addAttribute("id", id);
		model.addAttribute("countries", countryService.findAll());
		return BrandTemplateshttp.edit.getAdress();	
	}
	
	public String getBrandsList(Model model, Principal principal) {
	    model.addAttribute("principal",usuarioService.findByEmail(principal.getName()));
	    model.addAttribute("brandList", findAll());
		return BrandTemplateshttp.painel.getAdress();
	}

}
