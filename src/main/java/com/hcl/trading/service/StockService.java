package com.hcl.trading.service;

import java.util.List;

import com.hcl.trading.dto.StockDetailsDto;

public interface StockService {

	public List<StockDetailsDto> stocks();
}
