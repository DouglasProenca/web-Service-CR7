package com.webServiceCR7Imports.webServiceCR7.model.dto;

import com.webServiceCR7Imports.webServiceCR7.model.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandRequest {

    String brandName;
    Integer country;
    
    public BrandRequest(Brand brand) {
    	this.brandName = brand.getBrandName();
    	this.country = brand.getCountry().getIdCountry();		
    }
}
