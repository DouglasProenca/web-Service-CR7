package com.webServiceCR7Imports.webServiceCR7.model;

import java.util.Objects;

public class Country {
	
	private String namePort;
	private String nameEng;
	private int id;
	
	public Country() {
		
	}
	

	public Country(int id) {
		super();
		this.id = id;
	}


	public Country(String namePort, String nameEng, int id) {
		super();
		this.namePort = namePort;
		this.nameEng = nameEng;
		this.id = id;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNamePort() {
		return namePort;
	}

	public void setNamePort(String namePort) {
		this.namePort = namePort;
	}

	public String getNameEng() {
		return nameEng;
	}

	public void setNameEng(String nameEng) {
		this.nameEng = nameEng;
	}


	@Override
	public int hashCode() {
		return Objects.hash(id, nameEng, namePort);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Country other = (Country) obj;
		return id == other.id && Objects.equals(nameEng, other.nameEng) && Objects.equals(namePort, other.namePort);
	}
	
	
	
}
