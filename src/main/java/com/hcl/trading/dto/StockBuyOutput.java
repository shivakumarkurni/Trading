package com.hcl.trading.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StockBuyOutput {
	
	private String message;
	private Integer	statusCode;
	private Integer	purchaseId;
		

}
