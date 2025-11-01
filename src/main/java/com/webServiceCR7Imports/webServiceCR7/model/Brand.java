package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Date;

import com.webServiceCR7Imports.webServiceCR7.model.response.CountryResponse;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Brand {

	Integer brandId;
	String brandName;
	CountryResponse country;
	Date date;
	Usuario user;
	
}
