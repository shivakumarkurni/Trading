package com.hcl.trading.service;

import com.hcl.trading.dto.StockBuyInput;
import com.hcl.trading.dto.StockBuyOutput;
import com.hcl.trading.dto.StockbuyModificationInput;

public interface StockBuyService {

	public StockBuyOutput stockbuy(StockBuyInput stockBuyInput);
	public StockbuyModificationInput stockbuyModification(StockbuyModificationInput stockbuyModificationInput);

	
}
