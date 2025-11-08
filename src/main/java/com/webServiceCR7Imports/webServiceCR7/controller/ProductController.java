package com.webServiceCR7Imports.webServiceCR7.controller;

import java.time.LocalDate;

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

import com.webServiceCR7Imports.webServiceCR7.enums.ProductTemplateshttp;
import com.webServiceCR7Imports.webServiceCR7.model.dto.ProductRequest;
import com.webServiceCR7Imports.webServiceCR7.model.Product;
import com.webServiceCR7Imports.webServiceCR7.service.BrandService;
import com.webServiceCR7Imports.webServiceCR7.service.CategoryService;
import com.webServiceCR7Imports.webServiceCR7.service.ProductService;

import lombok.AllArgsConstructor;


@Controller
@AllArgsConstructor
@RequestMapping("admin/product")
public class ProductController {
	
	private final ProductService productService;
	private final BrandService BrandService;
	private final CategoryService categoryService;

	
	@GetMapping("/list/{page}")
	public String productsList(Model model, @PathVariable Integer page) {
	    model.addAttribute("productList",productService.pagelist(page == null? 0: page));
	    model.addAttribute("tipo", 0);
		return ProductTemplateshttp.PAINEL.toString();
	}
	
	
	@GetMapping("/find/{page}")
	public String searchProducts(@RequestParam("product") String productName, Model model ,@PathVariable Integer page) throws Exception {		
	    model.addAttribute("productList",productService.findByNamePage(productName,page == null? 0: page));
	    model.addAttribute("tipo", 1);
	    model.addAttribute("pesquisa",productName);
		return ProductTemplateshttp.PAINEL.toString();
	}
	
	@GetMapping("/form/{totalPages}")
	public String form(Model model, @PathVariable Integer totalPages) {
		model.addAttribute("brands", BrandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		model.addAttribute("totalPages", totalPages);
		model.addAttribute("tipo",0);
		model.addAttribute("product", new ProductRequest());
		return ProductTemplateshttp.REGISTER.toString();
	}
	
	@PostMapping("/newProduct/{totalPages}")
	public String newProduct(ProductRequest product, @PathVariable Integer totalPages) {
		productService.save(new ProductRequest(product.getProductName(), product.getBrand(), product.getPrice(), product.getAmount(), true, LocalDate.now(), product.getCategory()));	
		return ProductTemplateshttp.REDIRECT.toString()+totalPages;
	}
	
	@GetMapping("/{id}/{page}")
	public String formUpdateProduct(@PathVariable Integer id, @PathVariable Integer page, Model model) throws Exception {
		model.addAttribute("product", productService.findOne(id));
		model.addAttribute("id", id);
		model.addAttribute("page", page);
		model.addAttribute("brands", BrandService.findAll());
		model.addAttribute("categories", categoryService.findAll());
		return ProductTemplateshttp.REGISTER.toString();	
	}
	
	@PostMapping("/{id}/statusproduct/{page}")
	public String statusProduct(@PathVariable Integer id, @PathVariable Integer page) throws Exception {
		Product product = productService.findOne(id);
		product.setEnabled(!product.getEnabled());
		productService.update(id, new ProductRequest());
		return ProductTemplateshttp.REDIRECT.toString()+ page;
	}
	
	@PostMapping("/{id}/editProduct/{page}")
	public String editProduct(@PathVariable Integer id, @PathVariable Integer page, Product product) throws Exception {
		productService.findOne(id);
		
		ProductRequest productRequestUpdate = new ProductRequest();
		//productRequestUpdate.set(id);
		productRequestUpdate.setProductName(product.getProductName());
		productRequestUpdate.setBrand(product.getBrand().getBrandId());
		productRequestUpdate.setPrice(product.getPrice());
		productRequestUpdate.setAmount(product.getAmount());
		productRequestUpdate.setEnabled(product.getEnabled());
		productRequestUpdate.setDate(LocalDate.now());
		productRequestUpdate.setCategory(product.getCategory().getCategoryId());
		
		productService.update(id,productRequestUpdate);
		return ProductTemplateshttp.REDIRECT.toString()+ page;
	}
	
	@GetMapping("/{id}/delete")
	public String deleteBrand(@PathVariable Integer id) {
		productService.delete(id);	
		return ProductTemplateshttp.REDIRECT.toString();
	}
	
	@GetMapping("/excel")
	public ResponseEntity<byte[]> getExcel() {
	 	HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", "products.xlsx");
		return new ResponseEntity<>(productService.getExcel(), headers, HttpStatus.OK);
	}
	
}


