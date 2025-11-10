package com.webServiceCR7Imports.webServiceCR7.controller;

import java.io.IOException;
import java.util.Base64;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.webServiceCR7Imports.webServiceCR7.model.request.MailRequest;
import com.webServiceCR7Imports.webServiceCR7.service.EmailService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
@RequestMapping("/admin/email")
public class EmailController {

	private final EmailService emailService;
	
	@GetMapping
	public String brandsList(Model model) {
		model.addAttribute("mailRequest", new MailRequest());
		return "email/painel-email";
	}
	
	@PostMapping
	public String sendMail(MailRequest mailRequest, MultipartFile anexo, Model model) throws IOException {
		if (anexo != null) {
	         mailRequest.setAttachmentTitle(anexo.getOriginalFilename());
	         mailRequest.setAttachmentFile(Base64.getEncoder().encodeToString(anexo.getBytes()));
		}
		emailService.sendMail(mailRequest);
		return "redirect:/admin/email";
	}

}
