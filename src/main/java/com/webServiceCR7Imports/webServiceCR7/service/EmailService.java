package com.webServiceCR7Imports.webServiceCR7.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.webServiceCR7Imports.webServiceCR7.model.request.MailRequest;

@Service
@FeignClient(name = "mail", url = "http://localhost:8888/apicr7imports/private/mail")
public interface EmailService {

	@PostMapping
	void sendMail(@RequestBody MailRequest mailRequest);
}
