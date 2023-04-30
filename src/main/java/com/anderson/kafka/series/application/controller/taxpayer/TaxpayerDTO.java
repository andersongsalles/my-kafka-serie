package com.anderson.kafka.series.application.controller.taxpayer;


import com.anderson.kafka.series.shared.dto.CommonDTO;
import com.anderson.kafka.series.validation.Cpf;
import lombok.Data;

@Data
public class TaxpayerDTO implements CommonDTO {
	
	private String name;
	
	@Cpf
	private String document;
	
	private String email;

	@Override
	public String getType() {
		return "TaxPayerDTO";
	}

}
