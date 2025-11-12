package com.webServiceCR7Imports.webServiceCR7.model.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ProductResponsePagination {

	List<ProductResponse> content;
	Integer number;
	Integer pageSize;
	Boolean last;
	Integer totalPages;
	Boolean first;
	Boolean empty;
	
}