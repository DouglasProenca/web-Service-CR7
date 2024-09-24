package com.webServiceCR7Imports.webServiceCR7.model.dto;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MailResponse {

	 String destinatario;
	 String assunto;
	 String texto;
	 MultipartFile anexoFile;
	 
}
