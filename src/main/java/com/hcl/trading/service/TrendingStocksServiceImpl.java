package com.hcl.trading.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.TrendingStocksDTO;
import com.hcl.trading.repository.PurchaseRepository;
import com.hcl.trading.repository.StockRepository;

@Service
public class TrendingStocksServiceImpl implements TrendingStocksService {

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<TrendingStocksDTO> trendingStocks() {

		List<TrendingStocksDTO> purchaseList = purchaseRepository.findByPurchaseStatus("CONFIRMED");

		return purchaseList;
	}

}
