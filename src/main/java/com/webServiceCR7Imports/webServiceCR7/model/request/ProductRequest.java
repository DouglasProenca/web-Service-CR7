package com.webServiceCR7Imports.webServiceCR7.model.request;

import java.time.LocalDate;

import com.webServiceCR7Imports.webServiceCR7.model.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductRequest {
	
	String productName;
	Integer brand;
	Double price;
	Integer amount;
	Boolean enabled;
	LocalDate date;
	Integer category;
	
    public ProductRequest(Product product) {
    	this.productName = product.getProductName();
    	this.brand = product.getBrand().getBrandId();
    	this.price = product.getPrice();
    	this.amount = product.getAmount();
    	this.enabled = product.getEnabled();
    	this.date = LocalDate.now();
    	this.category = product.getCategory().getCategoryId();		
    }
}
