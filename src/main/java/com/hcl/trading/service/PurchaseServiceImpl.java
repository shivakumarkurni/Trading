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
import com.hcl.trading.exception.TradingException;
import com.hcl.trading.repository.PurchaseRepository;
import com.hcl.trading.repository.StockRepository;


/**
 * @author Shiva
 * 
 * This class will check the status of stocks and return list of Purchased stocks
 *
 */
@Service
public class PurchaseServiceImpl implements PurchaseService {

	private static final Logger logger = LoggerFactory.getLogger(PurchaseServiceImpl.class);

	@Autowired
	PurchaseRepository purchaseRepository;

	@Autowired
	StockRepository stockRepository;
	
	/**
	 * This method returns the list of Accepted stocks/CANCEL stocks
	 * 
	 * @param  userId,status
	 * 
	 * @return PurchaseDTO
	 *
	 */

	@Override
	public List<PurchaseDTO> purchasedList(Integer userId, String status) {

		logger.info("Inside PurchaseServiceImpl userId:{}, status:{}", userId, status);

		PurchaseDTO purchaseDTO = null;
		List<PurchaseDTO> purchasedDTOList = new ArrayList<>();
		List<Purchase> purchasedList = purchaseRepository.findByUserIdAndPurchaseStatus(userId, status);

		for (Purchase purchase : purchasedList) {

			Integer stockId = purchase.getStockId();

			Optional<Stock> optStock = stockRepository.findById(stockId);

			if (!optStock.isPresent())
				throw new TradingException("no stock available");

			Stock stock = optStock.get();

			String stockName = stock.getStockName();

			purchaseDTO = new PurchaseDTO();
			purchaseDTO.setStockName(stockName);
			purchaseDTO.setStockQuantity(purchase.getQuantity());
			purchaseDTO.setAmount(purchase.getAmount());
			purchaseDTO.setPurchaseDate(purchase.getPurchaseDate());
			purchaseDTO.setPurchaseStatus(purchase.getPurchaseStatus());

			purchasedDTOList.add(purchaseDTO);

		}

		return purchasedDTOList;
	}

}