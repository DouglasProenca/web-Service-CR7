package com.webServiceCR7Imports.webServiceCR7.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class MailRequest {
	
	 String adress;
	 String subject;
	 String text;
	 String attachmentTitle;
	 String attachmentFile; 

}
