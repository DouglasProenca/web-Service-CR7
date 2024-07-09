package com.webServiceCR7Imports.webServiceCR7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginController {
	
	@GetMapping("/admin/login")
	public String loginBackOffice() {
		return "admin/login";
	}
}
