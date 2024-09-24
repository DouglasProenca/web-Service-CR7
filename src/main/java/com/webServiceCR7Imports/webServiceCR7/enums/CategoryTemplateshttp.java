package com.webServiceCR7Imports.webServiceCR7.enums;

public enum CategoryTemplateshttp implements httpAdressTemplatInterface {

	painel {

		@Override
		public String getAdress() {
			return "category/painel-category";
		}

	},
	
	registrer {

		@Override
		public String getAdress() {
			return "category/cadastro-category";
		}
	},
	
	redirect {

		@Override
		public String getAdress() {
			return "redirect:/admin/category/";
		}
	}

}
