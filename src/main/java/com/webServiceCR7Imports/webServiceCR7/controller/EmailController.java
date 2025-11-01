package com.webServiceCR7Imports.webServiceCR7.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webServiceCR7Imports.webServiceCR7.model.dto.MailRequest;
import com.webServiceCR7Imports.webServiceCR7.model.dto.MailResponse;
import com.webServiceCR7Imports.webServiceCR7.service.EmailService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/email")
public class EmailController {

	private final EmailService emailService;
	
	@GetMapping
	public String brandsList(Model model) {
		model.addAttribute("mailRequest", new MailResponse());
		return "email/painel-email";
	}
	
	@PostMapping
	public String sendMail(MailResponse mailResponse, Model model) throws IOException {
		MailRequest mailRequest = new MailRequest();
		mailRequest.setAssunto(mailResponse.getAssunto());
		mailRequest.setDestinatario(mailResponse.getDestinatario());
		mailRequest.setTexto(mailResponse.getTexto());
		mailRequest.setAnexoTitulo(mailResponse.getAnexoFile().getOriginalFilename());
		mailRequest.setAnexoFile(Base64.getEncoder().encodeToString(mailResponse.getAnexoFile().getBytes()));
		emailService.sendMail(mailRequest);
		return "redirect:/admin/email";
	}

}
