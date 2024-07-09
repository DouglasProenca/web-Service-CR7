package com.webServiceCR7Imports.webServiceCR7.Enum;

public enum ProductTemplateshttp implements httpAdressTemplatInterface {

	painel {

		@Override
		public String getAdress() {
			return "product/painel-product";
		}

	},

	edit {

		@Override
		public String getAdress() {
			return "product/editar-product";
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
			return "redirect:/admin/product/";
		}
	}

}
