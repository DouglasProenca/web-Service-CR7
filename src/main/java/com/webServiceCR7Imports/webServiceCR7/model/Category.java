package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Date;

public class Category {
	
	private Integer id;
	private String categoria;
	private Date data;
	private Usuario user;
	
	public Category() {
		
	}

	
	
	public Category(Integer id) {
		super();
		this.id = id;
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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

	public Usuario getUser() {
		return user;
	}

	public void setUser(Usuario user) {
		this.user = user;
	}

}
