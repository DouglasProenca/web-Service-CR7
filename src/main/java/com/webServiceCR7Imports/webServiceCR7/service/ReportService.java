package com.webServiceCR7Imports.webServiceCR7.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "reports", url = "http://localhost:8088/apicr7imports/private/jasper")
public interface ReportService {
	
	@GetMapping("/analyticalReport?dateini&datefin")
	byte[] getAnalyticalReport(@RequestParam("dateini") String dataIni,@RequestParam("datefin") String dataFin);
	
	@GetMapping("/syntheticReport?dateini&datefin")
	byte[] getSyntheticReport(@RequestParam("dateini") String dataIni,@RequestParam("datefin") String dataFin);
	
	@GetMapping("/managentmentReport")
	byte[] getManagentmentReport();
}
