package com.webServiceCR7Imports.webServiceCR7.dto;

public class AcessRequest {

	private String username;
	private String password;
	
	public AcessRequest() {
		
	}
	
	public AcessRequest(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
