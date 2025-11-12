package com.webServiceCR7Imports.webServiceCR7.model.response;

import com.webServiceCR7Imports.webServiceCR7.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductResponse {
	
	Integer productId;
	String productName;
	Integer amount;
	BrandResponse brand;
	CategoryResponse category;
	Double price;
	Usuario user;
	Boolean enabled;	
	
}