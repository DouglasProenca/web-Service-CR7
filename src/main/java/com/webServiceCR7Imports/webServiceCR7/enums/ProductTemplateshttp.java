package com.webServiceCR7Imports.webServiceCR7.enums;

public enum ProductTemplateshttp implements httpAdressTemplatInterface {

	painel {

		@Override
		public String getAdress() {
			return "product/painel-product";
		}

	},
	
	registrer {

		@Override
		public String getAdress() {
			return "product/cadastro-product";
		}
	},
	
	redirect {

		@Override
		public String getAdress() {
			return "redirect:/admin/product/list/";
		}
	}

}
