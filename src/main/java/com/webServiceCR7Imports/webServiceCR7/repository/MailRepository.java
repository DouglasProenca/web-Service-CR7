package com.webServiceCR7Imports.webServiceCR7.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import com.webServiceCR7Imports.webServiceCR7.dto.BrandRequest;
import com.webServiceCR7Imports.webServiceCR7.dto.MailRequest;


@FeignClient(name = "mail", url = "http://localhost:8088/apicr7imports/private/mail")
public interface MailRepository {

	@PostMapping
	BrandRequest sendMail(@RequestBody MailRequest mailRequest);

}
