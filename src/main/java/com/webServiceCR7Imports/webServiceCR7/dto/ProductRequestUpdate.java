package com.webServiceCR7Imports.webServiceCR7.dto;

import java.util.Date;

public class ProductRequestUpdate {
	
	private int id;
	private String nome;
	private Integer brand;
	private double valor;
	private Integer quantidade;
	private boolean ativo;
	private Date data;
	private Integer user;
	private Integer category;
	
	
	
	/**
	 * 
	 */
	public ProductRequestUpdate() {
		super();
	}
	
	/**
	 * @param id
	 * @param nome
	 * @param brand
	 * @param valor
	 * @param quantidade
	 * @param ativo
	 * @param data
	 * @param user
	 * @param category
	 */
	public ProductRequestUpdate(int id, String nome, Integer brand, double valor, Integer quantidade, boolean ativo,
			Date data, Integer user, Integer category) {
		super();
		this.id = id;
		this.nome = nome;
		this.brand = brand;
		this.valor = valor;
		this.quantidade = quantidade;
		this.ativo = ativo;
		this.data = data;
		this.user = user;
		this.category = category;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome the nome to set
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 * @return the brand
	 */
	public Integer getBrand() {
		return brand;
	}
	/**
	 * @param brand the brand to set
	 */
	public void setBrand(Integer brand) {
		this.brand = brand;
	}
	/**
	 * @return the valor
	 */
	public double getValor() {
		return valor;
	}
	/**
	 * @param valor the valor to set
	 */
	public void setValor(double valor) {
		this.valor = valor;
	}
	/**
	 * @return the quantidade
	 */
	public Integer getQuantidade() {
		return quantidade;
	}
	/**
	 * @param quantidade the quantidade to set
	 */
	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
	/**
	 * @return the ativo
	 */
	public boolean isAtivo() {
		return ativo;
	}
	/**
	 * @param ativo the ativo to set
	 */
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	/**
	 * @return the data
	 */
	public Date getData() {
		return data;
	}
	/**
	 * @param data the data to set
	 */
	public void setData(Date data) {
		this.data = data;
	}
	/**
	 * @return the user
	 */
	public Integer getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(Integer user) {
		this.user = user;
	}
	/**
	 * @return the category
	 */
	public Integer getCategory() {
		return category;
	}
	/**
	 * @param category the category to set
	 */
	public void setCategory(Integer category) {
		this.category = category;
	}
	
}