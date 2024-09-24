package com.webServiceCR7Imports.webServiceCR7.model;

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
	Category category;
	Double price;
	Usuario user;
	Boolean enabled;	
	
}