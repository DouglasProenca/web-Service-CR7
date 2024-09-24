package com.webServiceCR7Imports.webServiceCR7.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Country {
	
	Integer idCountry;
	String namePort;
	String nameEng;

	public Country(Integer idCountry) {
		this.idCountry = idCountry;
	}	
}
