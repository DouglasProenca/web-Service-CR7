package com.webServiceCR7Imports.webServiceCR7.Enum;

public enum BrandTemplateshttp implements httpAdressTemplatInterface {

	painel {

		@Override
		public String getAdress() {
			return "brand/painel-brand";
		}

	},

	edit {

		@Override
		public String getAdress() {
			return "brand/editar-brand";
		}
	},
	
	registrer {

		@Override
		public String getAdress() {
			return "brand/cadastro-brand";
		}
	},
	
	redirect {

		@Override
		public String getAdress() {
			return "redirect:/admin/brand/";
		}
	}

}
