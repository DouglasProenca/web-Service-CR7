package com.webServiceCR7Imports.webServiceCR7.service;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webServiceCR7Imports.webServiceCR7.Enum.ProductTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.dto.ProductRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.ProductRequestUpdate;
import com.webServiceCR7Imports.webServiceCR7.dto.ProductResponsePagination;
import com.webServiceCR7Imports.webServiceCR7.model.Product;
import com.webServiceCR7Imports.webServiceCR7.repository.ProdutoRepository;


@Service
public class ProductService {

	@Autowired
	ProdutoRepository repository;

	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	BrandService BrandService;
	
	@Autowired
	CategoryService categoryService;

	public ProductResponsePagination pagelist(Integer page) {
		if(page == null) page = 0;		
		return repository.pagelist(page);
	}
	
	public ProductResponsePagination pagelistByName(String name,Integer page) {
		if(page == null) page = 0;		
		return repository.findByNamePage(name,page);
	}

	public String save(ProductRequest product, Principal principal, Integer totalPages) {
		int idUser = Integer.valueOf(String.valueOf(usuarioService.findByEmail(principal.getName()).getId()));
		repository.save(new ProductRequest(product.getNome(), product.getBrand(), product.getValor(), product.getQuantidade(), true, new Date(),idUser, product.getCategory()));	
		return ProductTemplateshttp.redirect.getAdress()+totalPages;
	}

	public Product findOne(Integer id) throws Exception {
		return repository.findById(id).orElseThrow(() -> new Exception("Produto não localizada"));
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	public void update(Integer id, Product product,Principal principal) throws Exception {
		repository.findById(id).orElseThrow(() -> new Exception("Produto não localizado"));
		
		Integer idUser = Integer.valueOf(String.valueOf(usuarioService.findByEmail(principal.getName()).getId()));

		ProductRequestUpdate productRequestUpdate = new ProductRequestUpdate();
		productRequestUpdate.setId(id);
		productRequestUpdate.setNome(product.getNome());
		productRequestUpdate.setBrand(product.getBrand().getId());
		productRequestUpdate.setValor(product.getValor());
		productRequestUpdate.setQuantidade(product.getQuantidade());
		productRequestUpdate.setAtivo(product.getAtivo());
		productRequestUpdate.setData(new Date());
		productRequestUpdate.setUser(idUser);
		productRequestUpdate.setCategory(product.getCategory().getId());
		
		repository.update(productRequestUpdate);
	}
	
	public ResponseEntity<byte[]> getExcel() {
	 	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "products.xlsx");
		return new ResponseEntity<>(repository.getExcel(), headers, HttpStatus.OK);
	}
	
	public String getSearchProducts(String name,Model model, Principal principal,Integer page) throws Exception {
	    model.addAttribute("principal",usuarioService.findByEmail(principal.getName()));
	    model.addAttribute("productList", pagelistByName(name,page));
	    model.addAttribute("tipo", 1);
	    model.addAttribute("pesquisa",name);
		return ProductTemplateshttp.painel.getAdress();
	}
	
	public String getForm(Product product,Model model,Integer totalPages) {
		model.addAttribute("brands", BrandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("tipo",0);
		return ProductTemplateshttp.registrer.getAdress();
	}
	
	public String getFormUpdateProduct(Integer id, Integer page,Principal principal, Model model) throws Exception {
		model.addAttribute("product", findOne(id));
		model.addAttribute("id", id);
		model.addAttribute("page", page);
		model.addAttribute("brands", BrandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return ProductTemplateshttp.registrer.getAdress();	
	}
	
	public String getProductsList(Model model, Principal principal,Integer page) {
	    model.addAttribute("principal",usuarioService.findByEmail(principal.getName()));
	    model.addAttribute("productList", pagelist(page));
	    model.addAttribute("tipo", 0);
		return ProductTemplateshttp.painel.getAdress();
	}
	
	public void alterStatus(Integer id, Principal principal) throws Exception {
		Product product = findOne(id);
		product.setAtivo(!product.getAtivo());
		update(id, product,principal);
	}
	
}