package com.webServiceCR7Imports.webServiceCR7.service;

import java.security.Principal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webServiceCR7Imports.webServiceCR7.Enum.CategoryTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.dto.CategoryRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.CategoryRequestUpdate;
import com.webServiceCR7Imports.webServiceCR7.model.Category;
import com.webServiceCR7Imports.webServiceCR7.repository.CategoryRepository;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repository;

	@Autowired
	UsuarioService usuarioService;

	public List<Category> findAll() {
		return repository.findAll();
	}

	public List<Category> findByName(String name) {
		return repository.findByName(name);
	}

	public String save(CategoryRequest category) {
		repository.saveCategory(new CategoryRequest(category.getCategoria(), LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
		return CategoryTemplateshttp.redirect.getAdress();
	}

	public Category findOne(int id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Categoria não localizada"));
	}

	public String delete(int id) {
		repository.deleteById(id);
		return CategoryTemplateshttp.redirect.getAdress();
	}

	public String update(int id, Category category) throws Exception {
		repository.findById(id).orElseThrow(() -> new Exception("Categoria não localizada"));

		CategoryRequestUpdate brandRequestUpdate = new CategoryRequestUpdate();
		brandRequestUpdate.setId(id);
		brandRequestUpdate.setCategoria(category.getCategoria());
		brandRequestUpdate.setData(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));

		repository.updateCategory(brandRequestUpdate);
		return CategoryTemplateshttp.redirect.getAdress();
	}

	public ResponseEntity<byte[]> getExcel() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "categorys.xlsx");
		return new ResponseEntity<>(repository.getExcel(), headers, HttpStatus.OK);
	}

	public String getSearchCategorys(String nomeMarca, Model model, Principal principal) throws Exception {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		model.addAttribute("categoryList", findByName(nomeMarca));
		return CategoryTemplateshttp.painel.getAdress();
	}

	public String getForm(Category category, Model model) {
		model.addAttribute("tipo",0);
		return CategoryTemplateshttp.registrer.getAdress();
	}

	public String getFormUpdateCategory(int id, Principal principal, Model model) throws Exception {
		model.addAttribute("category", findOne(id));
		model.addAttribute("id", id);
		return CategoryTemplateshttp.registrer.getAdress();
	}

	public String getCategorysList(Model model, Principal principal) {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		model.addAttribute("categoryList", findAll());
		return CategoryTemplateshttp.painel.getAdress();
	}
}
