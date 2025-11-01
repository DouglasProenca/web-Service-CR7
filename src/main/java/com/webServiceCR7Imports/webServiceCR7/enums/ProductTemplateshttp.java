package com.webServiceCR7Imports.webServiceCR7.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductTemplateshttp {

	PAINEL("product/painel-product"),
	REGISTER("product/cadastro-product"),
	REDIRECT("redirect:/admin/product/list/");
	
    private final String address;

	@Override
	public String toString() {
		return address;
	}
	
}
