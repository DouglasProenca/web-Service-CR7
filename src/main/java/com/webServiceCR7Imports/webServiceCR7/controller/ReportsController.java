package com.webServiceCR7Imports.webServiceCR7.controller;


import org.springframework.beans.factory.annotation.Autowired;
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
	    return reportService.getAnalyticalReport(dataIni,dataFin);
	}
	
	@GetMapping("/synthetic")
	public ResponseEntity<byte[]>getSyntheticReport(@RequestParam("sintetico-data-inicial") String dataIni
            									   ,@RequestParam("sintetico-data-final") String dataFin) {
	    return reportService.getSyntheticReport(dataIni,dataFin);
	}
	
	@GetMapping("/managentment")
	public ResponseEntity<byte[]>getManagentmentReport() {
	    return reportService.getManagentmentReport();
	}
}
