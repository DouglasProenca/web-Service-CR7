package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Brand {

	Integer brandId;
	String brandName;
	Country country;
	Date date;
	Usuario user;
	
}
