package com.anderson.kafka.series.application.controller.taxpayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/taxpayer")
public class TaxpayerController {
	
	@Autowired
	private TaxpayerService taxpayerService;
	
	@PostMapping
	public ResponseEntity<TaxpayerDTO> postTaxpayer(@Valid @RequestBody TaxpayerDTO taxpayer){
		
		taxpayerService.send(taxpayer);
		
		return ResponseEntity.ok(taxpayer);
	}

}
