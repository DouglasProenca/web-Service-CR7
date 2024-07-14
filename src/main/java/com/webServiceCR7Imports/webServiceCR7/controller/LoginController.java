package com.webServiceCR7Imports.webServiceCR7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class LoginController {
	
	@GetMapping("/admin/login")
	public String loginBackOffice() {
		return "admin/login";
	}
	
	@PostMapping("/admin/login")
	public String login() {
		return "admin/login";
	}
}
