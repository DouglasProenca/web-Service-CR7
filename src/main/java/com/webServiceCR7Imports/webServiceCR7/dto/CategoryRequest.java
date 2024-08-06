package com.webServiceCR7Imports.webServiceCR7.dto;

public class CategoryRequest {

    String categoria;
    String data;
    
	public CategoryRequest(String categoria, String data) {
		super();
		this.categoria = categoria;
		this.data = data;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
}
