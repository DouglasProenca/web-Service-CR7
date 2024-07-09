package com.webServiceCR7Imports.webServiceCR7.dto;

import java.util.Date;

public class BrandRequestUpdate {

	private int id;
    private String marca;
    private int country;
    private Date data;
    private Integer user;
    
	public BrandRequestUpdate(int id, String marca, int country, Date data, Integer user) {
		super();
		this.id = id;
		this.marca = marca;
		this.country = country;
		this.data = data;
		this.user = user;
	}

	public BrandRequestUpdate() {

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public int getCountry() {
		return country;
	}

	public void setCountry(int country) {
		this.country = country;
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
