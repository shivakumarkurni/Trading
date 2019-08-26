package com.hcl.trading.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class TrendingStocksDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	private Integer stockId;
	private String stockName;
	private Long count;

}
