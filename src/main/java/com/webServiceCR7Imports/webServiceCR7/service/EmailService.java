package com.webServiceCR7Imports.webServiceCR7.service;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;


@Service
public class EmailService {
	
	@Autowired
	UsuarioService usuarioService;

	public String getEmail(Model model, Principal principal) {
		model.addAttribute("principal", usuarioService.findByEmail(principal.getName()));
		//model.addAttribute("categoryList", findAll());
		return "email/painel-email";
	}
}
