package com.webServiceCR7Imports.webServiceCR7.model.response;

import java.util.Date;

import com.webServiceCR7Imports.webServiceCR7.model.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryResponse {
	
	Integer categoryId;
	String categoryName;
	Date date;
	Usuario user;
	

}
