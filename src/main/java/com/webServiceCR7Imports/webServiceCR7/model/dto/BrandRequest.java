package com.webServiceCR7Imports.webServiceCR7.model.dto;

import com.webServiceCR7Imports.webServiceCR7.model.Brand;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BrandRequest {

    String brandName;
    Integer country;
    
    public BrandRequest(Brand brand) {
    	this.brandName = brand.getBrandName();
    	this.country = brand.getCountry().getIdCountry();		
    }
}
