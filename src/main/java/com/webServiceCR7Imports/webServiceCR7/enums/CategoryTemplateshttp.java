package com.webServiceCR7Imports.webServiceCR7.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum CategoryTemplateshttp {

	PAINEL("category/painel-category"),
	REGISTER("category/cadastro-category"),
	REDIRECT("redirect:/admin/category/");
	
    private final String address;

	@Override
	public String toString() {
		return address;
	}

}
