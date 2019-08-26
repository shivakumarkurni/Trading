package com.hcl.trading.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.EpurchaseStatus;
import com.hcl.trading.dto.StockBuyInput;
import com.hcl.trading.dto.StockBuyOutput;
import com.hcl.trading.dto.StockbuyModificationInput;
import com.hcl.trading.dto.StockbuyModificationOutput;
import com.hcl.trading.entity.Purchase;
import com.hcl.trading.entity.Stock;
import com.hcl.trading.entity.Trading;
import com.hcl.trading.exception.TradingException;
import com.hcl.trading.repository.PurchaseRepository;
import com.hcl.trading.repository.StockRepository;
import com.hcl.trading.repository.TradingRepository;

@Service
public class StockBuyServiceImpl implements StockBuyService {

	@Autowired
	TradingRepository tradingRepository;
	@Autowired
	StockRepository stockRepository;

	@Autowired
	PurchaseRepository purchaseRepository;

	/**
	 * saving of interestd stocks
	 * 
	 * @parm stockBuyInput : it will give the input parameters in a object
	 */
	@Override
	public StockBuyOutput stockbuy(StockBuyInput stockBuyInput) {

		/**
		 * stock final amount calculation
		 */

		Optional<Stock> stock = stockRepository.findById(stockBuyInput.getStockId());
		if (!stock.isPresent())
			throw new TradingException("stock not existed");

		List<Trading> tradings = tradingRepository.findByStockId(stockBuyInput.getStockId());

		Integer stockAmount;

		if (!tradings.isEmpty()) {
			Trading trading = tradings.get(tradings.size() - 1);
			stockAmount = trading.getTradingPrice() * stockBuyInput.getStockQuantity();
			stockAmount = stockAmount + (stockAmount % trading.getBrokarage());

		} else {
			stockAmount = stock.get().getStockPrice() * stockBuyInput.getStockQuantity();
			stockAmount = stockAmount + (stockAmount % 10);

		}

		Purchase purchase = new Purchase();
		purchase.setPurchaseDate(LocalDate.now());
		purchase.setPurchaseStatus(EpurchaseStatus.CART.name());
		purchase.setQuantity(stockBuyInput.getStockQuantity());
		purchase.setUserId(stockBuyInput.getUserId());
		purchase.setAmount(stockAmount);
		purchase.setStockId(stockBuyInput.getStockId());
		purchaseRepository.save(purchase);

		StockBuyOutput stockBuyOutput = new StockBuyOutput();
		stockBuyOutput.setMessage("stock succsessfully added");
		stockBuyOutput.setPurchaseId(purchase.getPurchaseId());
		stockBuyOutput.setStatusCode(HttpStatus.CREATED.value());

		return stockBuyOutput;
	}

	@Override
	public StockbuyModificationOutput stockbuyModification(StockbuyModificationInput stockbuyModificationInput) {

		Optional<Purchase> purchase = purchaseRepository.findById(stockbuyModificationInput.getPurchaseId());
		
		if (!purchase.isPresent())
			throw new TradingException("pucheses not existed");

		
		List<Trading> tradings = tradingRepository.findByStockId(purchase.get().getStockId());

		Optional<Stock> stock = stockRepository.findById(purchase.get().getStockId());

		Integer stockAmount;
		Integer brockarage;

		if (!tradings.isEmpty()) {
			Trading trading = tradings.get(tradings.size() - 1);
			stockAmount = trading.getTradingPrice() * stockbuyModificationInput.getQuantity();
			brockarage=stockAmount % trading.getBrokarage();

			stockAmount = stockAmount + brockarage;

		} else {
			stockAmount = stock.get().getStockPrice() * stockbuyModificationInput.getQuantity();
			brockarage=stockAmount /10;
			stockAmount = stockAmount + (stockAmount/ 10);

		}

		
		purchase.get().setQuantity(stockbuyModificationInput.getQuantity());
		purchase.get().setAmount(stockAmount);
		// Confirmation stock
		StockbuyModificationOutput stockbuyModificationOutput=new StockbuyModificationOutput();

		
		if (stockbuyModificationInput.getFlag().equals(1)) { // Confirmation stock

			purchase.get().setPurchaseStatus(EpurchaseStatus.ACCEPTED.name());
			stockbuyModificationOutput.setMessage("stock purchased succsessfully");

		}

		else if (stockbuyModificationInput.getFlag().equals(2)) { // Confirmation stock
			purchase.get().setPurchaseStatus(EpurchaseStatus.CANCEL.name());
			stockbuyModificationOutput.setMessage("stock cancelled");

			
			

		} else {
			purchase.get().setPurchaseStatus(EpurchaseStatus.CART.name());
			stockbuyModificationOutput.setMessage("stock modified");


		}

		purchaseRepository.save(purchase.get());
  
		stockbuyModificationOutput.setCurrentAmount(stockAmount);
		stockbuyModificationOutput.setBrokarage(brockarage);
		stockbuyModificationOutput.setPreviousAmount(stock.get().getStockPrice() * stockbuyModificationInput.getQuantity());
		stockbuyModificationOutput.setStatusCode(HttpStatus.CREATED.value());
		return stockbuyModificationOutput;
	}

}
