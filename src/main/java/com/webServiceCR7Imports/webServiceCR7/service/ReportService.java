package com.webServiceCR7Imports.webServiceCR7.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.webServiceCR7Imports.webServiceCR7.repository.ReportsRepository;

@Service
public class ReportService {
	
	@Autowired
	ReportsRepository repository;

	
	public ResponseEntity<byte[]> getAnalyticalReport(String dataIni,String dataFin) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "analitico.pdf");
		return new ResponseEntity<>(repository.getAnalyticalReport(dataIni,dataFin), headers, HttpStatus.OK);
	}
	
	public ResponseEntity<byte[]> getSyntheticReport(String dataIni,String dataFin) {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "sintetico.pdf");
		return new ResponseEntity<>(repository.getSyntheticReport(dataIni,dataFin), headers, HttpStatus.OK);
	}
	
	public ResponseEntity<byte[]> getManagentmentReport() {
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		headers.setContentDispositionFormData("attachment", "gerencial.pdf");
		return new ResponseEntity<>(repository.getManagentmentReport(), headers, HttpStatus.OK);
	}
}
