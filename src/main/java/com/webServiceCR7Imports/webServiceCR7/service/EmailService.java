package com.webServiceCR7Imports.webServiceCR7.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.webServiceCR7Imports.webServiceCR7.dto.MailRequest;
import com.webServiceCR7Imports.webServiceCR7.repository.MailRepository;

@Service
public class EmailService {

	@Autowired
	UsuarioService usuarioService;

	@Autowired
	MailRepository repository;

	public String getEmail(Model model, Principal principal) {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		model.addAttribute("mailRequest", new MailRequest());
		return "email/painel-email";
	}

	public String sendMail(MailRequest mailRequest, Principal principal,Model model) {
		repository.sendMail(mailRequest);
		return "redirect:/admin/email";
	}
}
