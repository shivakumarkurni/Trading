package com.hcl.trading.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StockbuyModificationOutput {

	private Integer CurrentAmount;
	private Integer brokarage;
	private Integer PreviousAmount;
	private String message;
	private Integer statusCode;

	
}
