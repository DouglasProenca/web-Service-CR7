package com.webServiceCR7Imports.webServiceCR7.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.dto.ProductRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.ProductRequestUpdate;
import com.webServiceCR7Imports.webServiceCR7.dto.ProductResponsePagination;
import com.webServiceCR7Imports.webServiceCR7.model.Product;

@FeignClient(name = "product", url = "http://localhost:8088/apicr7imports/private/product")
public interface ProdutoRepository {

	@GetMapping
    List<Product> findAll();
	
	@GetMapping("/pagelist?page=&limit=")
    ProductResponsePagination pagelist(@RequestParam("page") Integer pagina, @RequestParam("limit") Integer limite);
	
	@GetMapping("/searchproduct?product")
	List<Product> findByName(@RequestParam("product") String name);
	
	@PostMapping
	ProductRequest saveProduct(@RequestBody ProductRequest productRequest);
	
	@GetMapping("/{id}")
	Optional<Product> findById(@PathVariable("id") int id);
	
	@GetMapping("/excel")
	byte[] getExcel();
	
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable("id") int id);
	
	@PutMapping
	ProductRequestUpdate updateProduct(ProductRequestUpdate productRequestUpdate);
}