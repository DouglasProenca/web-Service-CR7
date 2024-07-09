package com.webServiceCR7Imports.webServiceCR7.dto;

import java.util.Date;

public class CategoryRequest {

    private String categoria;
    private Date data;
    private Integer user;
    
	public CategoryRequest(String categoria, Date data, Integer user) {
		super();
		this.categoria = categoria;
		this.data = data;
		this.user = user;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}
	
}
