package com.webServiceCR7Imports.webServiceCR7.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.webServiceCR7Imports.webServiceCR7.dto.MailRequest;
import com.webServiceCR7Imports.webServiceCR7.service.EmailService;

@Controller
@RequestMapping("/admin/email")
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@GetMapping
	public String brandsList(Model model, Principal principal) {
	    return emailService.getEmail(model, principal);
	}
	
	@PostMapping
	public String sendMail(MailRequest mailRequest, Principal principal,Model model) {
		return emailService.sendMail(mailRequest,principal,model);
	}

}
