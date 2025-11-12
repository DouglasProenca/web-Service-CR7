package com.webServiceCR7Imports.webServiceCR7.model.response;

import java.util.Date;

import com.webServiceCR7Imports.webServiceCR7.model.Usuario;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class BrandResponse {

	Integer brandId;
	String brandName;
	CountryResponse country;
	Date date;
	Usuario user;
	
}
