package com.webServiceCR7Imports.webServiceCR7.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.webServiceCR7Imports.webServiceCR7.service.ReportService;

@Controller
@RequestMapping("/admin/report")
public class ReportsController {

	@Autowired
	ReportService reportService;
	
	@GetMapping("/analytical")
	public ResponseEntity<byte[]>getAnalyticalReport(@RequestParam("analitico-data-inicial") String dataIni
			                                        ,@RequestParam("analitico-data-final") String dataFin) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "analitico.pdf");
		return new ResponseEntity<>(reportService.getAnalyticalReport(dataIni,dataFin), headers, HttpStatus.OK);
	}
	
	@GetMapping("/synthetic")
	public ResponseEntity<byte[]>getSyntheticReport(@RequestParam("sintetico-data-inicial") String dataIni
            									   ,@RequestParam("sintetico-data-final") String dataFin) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "sintetico.pdf");
		return new ResponseEntity<>(reportService.getSyntheticReport(dataIni,dataFin), headers, HttpStatus.OK);
	}
	
	@GetMapping("/managentment")
	public ResponseEntity<byte[]>getManagentmentReport() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "gerencial.pdf");
		return new ResponseEntity<>(reportService.getManagentmentReport(), headers, HttpStatus.OK);
	}
}
