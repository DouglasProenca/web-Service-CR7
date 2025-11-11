package com.webServiceCR7Imports.webServiceCR7.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Service
@FeignClient(name = "reports", url = "http://localhost:8888/apicr7imports/private/jasper")
public interface ReportService {
	
	@GetMapping("/analyticalReport?initial_date&final_date")
	byte[] getAnalyticalReport(@RequestParam("initial_date") String dataIni,@RequestParam("final_date") String dataFin);
	
	@GetMapping("/syntheticReport?dateini&final_date")
	byte[] getSyntheticReport(@RequestParam("initial_date") String dataIni,@RequestParam("final_date") String dataFin);
	
	@GetMapping("/managentmentReport")
	byte[] getManagentmentReport();
}
