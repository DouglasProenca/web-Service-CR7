package com.webServiceCR7Imports.webServiceCR7.dto;

public class CategoryRequestUpdate {

	private int id;
    private String categoria;
    private String data;
    
	public CategoryRequestUpdate(int id, String categoria, String data) {
		this.id = id;
		this.categoria = categoria;
		this.data = data;

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

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

    
}
