package com.hcl.trading.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

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
import com.hcl.trading.service.StockBuyServiceImpl;


@RunWith(MockitoJUnitRunner.class)
public class StockBuyServiceImplTest {

	
	@InjectMocks
	StockBuyServiceImpl stockBuyServiceImpl;
	
	
	
	@Mock
	TradingRepository tradingRepository;
	@Mock
	StockRepository stockRepository;

	@Mock
	PurchaseRepository purchaseRepository;
	
	Stock stock;
	Trading trading;
	List<Trading> tradings;
	
	StockBuyInput stockBuyInput;

	Purchase purchase;
	StockbuyModificationInput stockbuyModificationInput;
	@org.junit.Before
	public void setup() {
		
		 stock=new Stock();
		 stock.setStockId(1);
		 stock.setStockName("HCL");
		 stock.setStockPrice(100);
		 stock.setStockQuantity(1000);
		 stock.setStockSector("kkkkk");
		 
		 trading=new Trading();
		 trading.setBrokarage(3);
		 trading.setStockId(stock.getStockId());
		 trading.setTradingId(1);
		 trading.setTradingPrice(100);
		 
		 purchase=new Purchase();
		 purchase.setAmount(1000);
		 purchase.setPurchaseDate(LocalDate.now());
		 purchase.setPurchaseId(1);
		 purchase.setPurchaseStatus(EpurchaseStatus.CART.name());
		 purchase.setQuantity(10);
		 purchase.setStockId(stock.getStockId());
		 purchase.setUserId(1);
		 tradings=new ArrayList<>();
		 tradings.add(trading); 
		 
		 stockBuyInput=new StockBuyInput();
		 stockBuyInput.setFlag(1);
		 stockBuyInput.setStockQuantity(10);
		 stockBuyInput.setStockId(stock.getStockId());
		 stockBuyInput.setUserId(1);
		 
		 
		 stockbuyModificationInput=new StockbuyModificationInput();
		 stockbuyModificationInput.setFlag(1);
		 stockbuyModificationInput.setPurchaseId(1);
		 stockbuyModificationInput.setStockQuantity(10);
	}
	
	@Test
	public void stockbuy() {

		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
		Mockito.when(tradingRepository.findByStockId(Mockito.anyInt())).thenReturn(tradings);

		StockBuyOutput actual = stockBuyServiceImpl.stockbuy(stockBuyInput);
		
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());

	}

	@Test(expected = TradingException.class)
	public void stockbuyExcepton1() {


		 stockBuyServiceImpl.stockbuy(stockBuyInput);
		

	}
	
	@Test
	public void stockbuyExcepton2() {

		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
		Mockito.when(tradingRepository.findByStockId(Mockito.anyInt())).thenReturn(tradings);
		Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);

		StockBuyOutput actual = stockBuyServiceImpl.stockbuy(stockBuyInput);
		
			Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());

	}

	@Test(expected = TradingException.class)
	public void stockbuyModificationException() { 
		
		tradings.add(trading);
		
		Mockito.when(stockRepository.findById(Mockito.any())).thenReturn(Optional.of(stock));

		 stockBuyServiceImpl.stockbuyModification(stockbuyModificationInput);
	
	}

	
	@Test
	public void stockbuyModification() { 
		
		tradings.add(trading);
		
		Mockito.when(purchaseRepository.findById(stockbuyModificationInput.getPurchaseId())).thenReturn(Optional.of(purchase));
		Mockito.when(stockRepository.findById(Mockito.any())).thenReturn(Optional.of(stock));
		Mockito.when(tradingRepository.findByStockId(Mockito.any())).thenReturn(tradings);
		Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));

		StockbuyModificationOutput actual = stockBuyServiceImpl.stockbuyModification(stockbuyModificationInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());
	
	}
	
	@Test
	public void stockbuyModification2() { 
		
		tradings.add(trading);
		
		Mockito.when(purchaseRepository.findById(stockbuyModificationInput.getPurchaseId())).thenReturn(Optional.of(purchase));
		Mockito.when(stockRepository.findById(Mockito.any())).thenReturn(Optional.of(stock));
//		Mockito.when(tradingRepository.findByStockId(Mockito.any())).thenReturn(tradings);
		Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));

		StockbuyModificationOutput actual = stockBuyServiceImpl.stockbuyModification(stockbuyModificationInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());
	
	}
	
	@Test
	public void stockbuyModification3() { 
		
		tradings.add(trading);
		
		stockbuyModificationInput.setFlag(2);
		
		Mockito.when(purchaseRepository.findById(stockbuyModificationInput.getPurchaseId())).thenReturn(Optional.of(purchase));
		Mockito.when(stockRepository.findById(Mockito.any())).thenReturn(Optional.of(stock));
		Mockito.when(tradingRepository.findByStockId(Mockito.any())).thenReturn(tradings);
		Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));

		StockbuyModificationOutput actual = stockBuyServiceImpl.stockbuyModification(stockbuyModificationInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());
	
	}

	
	@Test
	public void stockbuyModification4() { 
		
		tradings.add(trading);
		
		stockbuyModificationInput.setFlag(10);
		
		Mockito.when(purchaseRepository.findById(stockbuyModificationInput.getPurchaseId())).thenReturn(Optional.of(purchase));
		Mockito.when(stockRepository.findById(Mockito.any())).thenReturn(Optional.of(stock));
		Mockito.when(tradingRepository.findByStockId(Mockito.any())).thenReturn(tradings);
		Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));

		StockbuyModificationOutput actual = stockBuyServiceImpl.stockbuyModification(stockbuyModificationInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCode().intValue());
	
	}

	
	@Test(expected = TradingException.class)
	public void stockbuyModification5() { 
		
		tradings.add(trading); 
		
		stockbuyModificationInput.setFlag(10);
		
		Mockito.when(purchaseRepository.findById(stockbuyModificationInput.getPurchaseId())).thenReturn(Optional.of(purchase));
//		Mockito.when(stockRepository.findById(Mockito.any())).thenReturn(Optional.of(stock));
		Mockito.when(tradingRepository.findByStockId(Mockito.any())).thenReturn(tradings);
		Mockito.when(purchaseRepository.save(purchase)).thenReturn(purchase);
//		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));

		stockBuyServiceImpl.stockbuyModification(stockbuyModificationInput);
	
	}

	 
}
