package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Date;

public class Brand {

	private String Marca;
	private Country country;
	private Date data;
	private Usuario user;
	private Integer id;
	
	public Brand() {
		
	}
	

	public Brand(Integer id) {
		super();
		this.id = id;
	}



	public String getMarca() {
		return Marca;
	}

	public void setMarca(String marca) {
		Marca = marca;
	}

	public Country getCountry() {
		return country;
	}

	public void setCountry(Country country) {
		this.country = country;
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

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	
}
