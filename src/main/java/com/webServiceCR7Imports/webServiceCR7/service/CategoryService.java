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

	public String save(CategoryRequest category, Principal principal) {
		int idUser = Integer.valueOf(String.valueOf(usuarioService.findByEmail(principal.getName()).getId()));
		repository.saveCategory(new CategoryRequest(category.getCategoria(), new Date(), idUser));
		return CategoryTemplateshttp.redirect.getAdress();
	}

	public Category findOne(int id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Categoria não localizada"));
	}

	public String delete(int id) {
		repository.deleteById(id);
		return CategoryTemplateshttp.redirect.getAdress();
	}

	public String update(int id, Category category, Principal principal) throws Exception {
		repository.findById(id).orElseThrow(() -> new Exception("Categoria não localizada"));

		Integer idUser = Integer.valueOf(String.valueOf(usuarioService.findByEmail(principal.getName()).getId()));

		CategoryRequestUpdate brandRequestUpdate = new CategoryRequestUpdate();
		brandRequestUpdate.setId(id);
		brandRequestUpdate.setCategoria(category.getCategoria());
		brandRequestUpdate.setData(new Date());
		brandRequestUpdate.setUser(idUser);

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
		return CategoryTemplateshttp.registrer.getAdress();
	}

	public String getFormUpdateCategory(int id, Principal principal, Model model) throws Exception {
		model.addAttribute("category", findOne(id));
		model.addAttribute("id", id);
		return CategoryTemplateshttp.edit.getAdress();
	}

	public String getCategorysList(Model model, Principal principal) {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		model.addAttribute("categoryList", findAll());
		return CategoryTemplateshttp.painel.getAdress();
	}
}
