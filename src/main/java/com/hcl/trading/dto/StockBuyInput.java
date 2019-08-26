package com.hcl.trading.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StockBuyInput {
	
		private Integer userId;
		private Integer stockId;
		private Integer stockQuantity;
		private Integer flag;
		

}
