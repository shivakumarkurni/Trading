package com.hcl.trading.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class StockDetailsDto implements Serializable{


	private static final long serialVersionUID = -5464486346176213909L;
	
	private String stockName;
	private Integer stockId;
	private String stockSector;
	private Integer stockQuantity;
	private Integer stockPrice;
}
