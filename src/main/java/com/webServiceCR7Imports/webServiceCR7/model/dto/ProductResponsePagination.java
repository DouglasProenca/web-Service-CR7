package com.webServiceCR7Imports.webServiceCR7.model.dto;

import java.util.List;

import com.webServiceCR7Imports.webServiceCR7.model.Product;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponsePagination {

	List<Product> content;
	Integer number;
	Integer pageSize;
	Boolean last;
	Integer totalPages;
	Boolean first;
	Boolean empty;
	
}