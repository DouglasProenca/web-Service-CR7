package com.webServiceCR7Imports.webServiceCR7.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webServiceCR7Imports.webServiceCR7.model.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.model.dto.MailRequest;

@Service
@FeignClient(name = "mail", url = "http://localhost:8088/apicr7imports/private/mail")
public interface EmailService {

	@PostMapping
	BrandRequest sendMail(@RequestBody MailRequest mailRequest);
}
