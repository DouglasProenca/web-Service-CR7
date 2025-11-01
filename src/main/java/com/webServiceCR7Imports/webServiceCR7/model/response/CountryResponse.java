package com.webServiceCR7Imports.webServiceCR7.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CountryResponse {
	
	Integer idCountry;
	String namePort;
	String nameEng;

	public CountryResponse(Integer idCountry) {
		this.idCountry = idCountry;
	}	
}
