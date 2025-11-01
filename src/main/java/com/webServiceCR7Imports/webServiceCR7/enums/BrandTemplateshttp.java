package com.webServiceCR7Imports.webServiceCR7.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum BrandTemplateshttp {

	PAINEL("brand/painel-brand"),
    REGISTER("brand/cadastro-brand"),
    REDIRECT("redirect:/admin/brand/");

    private final String address;

	@Override
	public String toString() {
		return address;
	}

}
