package com.webServiceCR7Imports.webServiceCR7.dto;

import java.util.Date;

public class CategoryRequestUpdate {

	private int id;
    private String categoria;
    private Date data;
    private Integer user;
    
	public CategoryRequestUpdate(int id, String categoria, Date data, Integer user) {
		super();
		this.id = id;
		this.categoria = categoria;
		this.data = data;
		this.user = user;
	}

	public CategoryRequestUpdate() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public Integer getUser() {
		return user;
	}

	public void setUser(Integer user) {
		this.user = user;
	}
    
    
}
