package com.webServiceCR7Imports.webServiceCR7.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "reports", url = "http://localhost:8088/apicr7imports/private/jasper")
public interface ReportsRepository {

	@GetMapping("/analyticalReport?dateini&datefin")
	byte[] getAnalyticalReport(@RequestParam("dateini") String dataIni,@RequestParam("datefin") String dataFin);
	
	@GetMapping("/syntheticReport?dateini&datefin")
	byte[] getSyntheticReport(@RequestParam("dateini") String dataIni,@RequestParam("datefin") String dataFin);

	@GetMapping("/managentmentReport")
	byte[] getManagentmentReport();
	
}
