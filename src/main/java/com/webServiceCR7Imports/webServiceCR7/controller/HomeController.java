package com.webServiceCR7Imports.webServiceCR7.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	
	@GetMapping("/admin")
	public String adminHome() {
		return "admin/home";
	}


	@ExceptionHandler(Exception.class)
	public String onError() {
		return "redirect:/home";
	}
}
