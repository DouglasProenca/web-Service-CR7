package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Date;

import com.webServiceCR7Imports.webServiceCR7.model.response.CountryResponse;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class Brand {

	Integer brandId;
	String brandName;
	CountryResponse country;
	Date date;
	Usuario user;
	
}
