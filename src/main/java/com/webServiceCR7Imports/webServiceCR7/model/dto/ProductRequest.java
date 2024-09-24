package com.webServiceCR7Imports.webServiceCR7.model.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductRequest {
	
	String productName;
	Integer brand;
	Double price;
	Integer amount;
	Boolean enabled;
	LocalDate date;
	Integer category;
	
}
