package com.webServiceCR7Imports.webServiceCR7.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.webServiceCR7Imports.webServiceCR7.model.Product;

@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductResponsePagination {

	private List<Product> content;
	private Integer number;
	private Integer pageSize;
	private boolean last;
	private Integer totalPages;
	private boolean first;
	private boolean empty;

	/**
	 * @return the content
	 */
	public List<Product> getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(List<Product> content) {
		this.content = content;
	}

	/**
	 * @return the number
	 */
	public Integer getNumber() {
		return number;
	}

	/**
	 * @param number the number to set
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}

	/**
	 * @return the pageSize
	 */
	public Integer getPageSize() {
		return pageSize;
	}

	/**
	 * @param pageSize the pageSize to set
	 */
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	/**
	 * @return the last
	 */
	public boolean isLast() {
		return last;
	}

	/**
	 * @param last the last to set
	 */
	public void setLast(boolean last) {
		this.last = last;
	}

	/**
	 * @return the totalPages
	 */
	public Integer getTotalPages() {
		return totalPages;
	}

	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPages(Integer totalPages) {
		this.totalPages = totalPages;
	}

	/**
	 * @return the first
	 */
	public boolean isFirst() {
		return first;
	}

	/**
	 * @param first the first to set
	 */
	public void setFirst(boolean first) {
		this.first = first;
	}

	/**
	 * @return the empty
	 */
	public boolean isEmpty() {
		return empty;
	}

	/**
	 * @param empty the empty to set
	 */
	public void setEmpty(boolean empty) {
		this.empty = empty;
	}

}