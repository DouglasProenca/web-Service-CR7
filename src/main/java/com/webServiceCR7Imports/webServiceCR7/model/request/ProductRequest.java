package com.webServiceCR7Imports.webServiceCR7.model.request;

import com.webServiceCR7Imports.webServiceCR7.model.response.ProductResponse;

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
	Integer category;
	
    public ProductRequest(ProductResponse product) {
    	this.productName = product.getProductName();
    	this.brand = product.getBrand().getBrandId();
    	this.price = product.getPrice();
    	this.amount = product.getAmount();
    	this.enabled = product.getEnabled();
    	this.category = product.getCategory().getCategoryId();		
    }
}
