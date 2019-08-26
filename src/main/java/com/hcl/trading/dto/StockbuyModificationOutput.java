package com.hcl.trading.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StockbuyModificationOutput {

	private Integer currentAmount;
	private Integer brokarage;
	private Integer previousAmount;
	private String message;
	private Integer statusCode;

	
}
