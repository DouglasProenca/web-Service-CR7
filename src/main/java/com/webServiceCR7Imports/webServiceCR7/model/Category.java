package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Category {
	
	Integer categoryId;
	String categoryName;
	Date date;
	Usuario user;
	

}
