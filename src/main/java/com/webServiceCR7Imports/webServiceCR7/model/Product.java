package com.webServiceCR7Imports.webServiceCR7.model;

import com.webServiceCR7Imports.webServiceCR7.model.response.CategoryResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product {
	
	Integer productId;
	String productName;
	Integer amount;
	Brand brand;
	CategoryResponse category;
	Double price;
	Usuario user;
	Boolean enabled;	
	
}