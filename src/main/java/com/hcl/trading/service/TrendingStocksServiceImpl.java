package com.hcl.trading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.TrendingStocksDTO;
import com.hcl.trading.repository.PurchaseRepository;
import com.hcl.trading.repository.StockRepository;

/**
 * @author Shiva
 * 
 *         This class will return the top trending stocks
 * 
 */

@Service
public class TrendingStocksServiceImpl implements TrendingStocksService {

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	StockRepository stockRepository;

	/**
	 * 
	 * This method will return the top trending stocks
	 * 
	 */

	@Override
	public List<TrendingStocksDTO> trendingStocks() {

		return purchaseRepository.findByPurchaseStatus("ACCEPTED");

	}

}
