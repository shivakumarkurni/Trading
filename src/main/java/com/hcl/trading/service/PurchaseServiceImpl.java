package com.hcl.trading.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.PurchaseDTO;
import com.hcl.trading.entity.Purchase;
import com.hcl.trading.entity.Stock;
import com.hcl.trading.repository.PurchaseRepository;
import com.hcl.trading.repository.StockRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	StockRepository stockRepository;

	@Override
	public List<PurchaseDTO> purchasedList(Integer userId, String status) {

		logger.info("Inside PurchaseServiceImpl:" + userId);
		logger.info("Inside PurchaseServiceImpl:" + status);

		PurchaseDTO purchaseDTO = null;
		List<PurchaseDTO> purchasedDTOList=new ArrayList<>();
		List<Purchase> purchasedList = purchaseRepository.findByUserIdAndPurchaseStatus(userId, status);

		for (Purchase purchase : purchasedList) {

			Integer stockId = purchase.getStockId();

			Optional<Stock> optStock = stockRepository.findById(stockId);

			Stock stock = optStock.get();

			String stockName = stock.getStockName();

			purchaseDTO = new PurchaseDTO();
			purchaseDTO.setStockName(stockName);
			purchaseDTO.setQuantity(purchase.getQuantity());
			purchaseDTO.setAmount(purchase.getAmount());
			purchaseDTO.setPurchaseDate(purchase.getPurchaseDate());
			purchaseDTO.setPurchaseStatus(purchase.getPurchaseStatus());
			
			purchasedDTOList.add(purchaseDTO);

		}

		return purchasedDTOList;
	}

}
