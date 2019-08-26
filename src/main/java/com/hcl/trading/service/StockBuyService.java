package com.hcl.trading.service;

import com.hcl.trading.dto.StockBuyInput;
import com.hcl.trading.dto.StockBuyOutput;
import com.hcl.trading.dto.StockbuyModificationInput;
import com.hcl.trading.dto.StockbuyModificationOutput;

public interface StockBuyService {

	public StockBuyOutput stockbuy(StockBuyInput stockBuyInput);
	public StockbuyModificationOutput stockbuyModification(StockbuyModificationInput stockbuyModificationInput);

	
}
