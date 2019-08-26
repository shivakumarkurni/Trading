package com.hcl.trading.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
public class PurchaseDTO implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String stockName;
	private Integer quantity;
	private Integer amount;
	private LocalDate purchaseDate;
	private String purchaseStatus;

}
