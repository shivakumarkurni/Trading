package com.hcl.trading.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class StockBuyInput {
	
		private Integer userId;
		private Integer stockId;
		private Integer quantity;
		private Integer flag;
		

}
