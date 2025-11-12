package com.webServiceCR7Imports.webServiceCR7.model.request;

import com.webServiceCR7Imports.webServiceCR7.model.response.BrandResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class BrandRequest {

    String brandName;
    Integer country;
    
    public BrandRequest(BrandResponse brand) {
    	this.brandName = brand.getBrandName();
    	this.country = brand.getCountry().getIdCountry();		
    }
}
