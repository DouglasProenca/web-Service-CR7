package com.webServiceCR7Imports.webServiceCR7.model.dto;

import com.webServiceCR7Imports.webServiceCR7.model.Category;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequest {

    String categoryName;
    
    public CategoryRequest(Category category) {
    	this.categoryName = category.getCategoryName();
    }
    
}
