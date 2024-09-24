package com.webServiceCR7Imports.webServiceCR7.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.model.dto.ProductRequest;
import com.webServiceCR7Imports.webServiceCR7.model.dto.ProductResponsePagination;
import com.webServiceCR7Imports.webServiceCR7.model.Product;

@Service
@FeignClient(name = "product", url = "http://localhost:8088/apicr7imports/private/product")
public interface ProductService {
	
	@GetMapping("/pagelist?page=")
    ProductResponsePagination pagelist(@RequestParam("page") Integer pagina);

	@PostMapping
	void save(@RequestBody ProductRequest productRequest);
	
	@GetMapping("/pagelist/searchproduct?product=&page=&limit=")
	ProductResponsePagination findByNamePage(@RequestParam("product") String name,@RequestParam("page") Integer pagina);

	@GetMapping("/{id}")
	Product findOne(@PathVariable("id") Integer id);

	@DeleteMapping("/{id}")
	void delete(@PathVariable("id") Integer id);
	

	@PutMapping("/{id}")
	void update(@PathVariable Integer id, @RequestBody ProductRequest productRequestUpdate);
	
	@GetMapping("/excel")
	byte[] getExcel();
	
}