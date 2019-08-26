package com.hcl.trading.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.trading.dto.StockBuyInput;
import com.hcl.trading.dto.StockBuyOutput;
import com.hcl.trading.dto.StockbuyModificationInput;
import com.hcl.trading.dto.StockbuyModificationOutput;
import com.hcl.trading.service.StockBuyService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class StockBuyControllerTest {
	
	@Mock StockBuyService stockBuyService;
	
	@InjectMocks StockBuyController stockBuyController;
	
	
	StockBuyInput stockBuyInput;

	
	StockBuyOutput stockBuyOutput;
	StockbuyModificationInput stockbuyModificationInput;
	StockbuyModificationOutput stockbuyModificationOutput;
	public void before() {
		stockBuyInput=new StockBuyInput();
		stockBuyInput.setFlag(1);
		stockBuyInput.setStockId(1);
		stockBuyInput.setStockQuantity(23);
		stockBuyInput.setUserId(1);
		stockBuyOutput=new StockBuyOutput();
		stockBuyOutput.setMessage("succsess");
		stockBuyOutput.setPurchaseId(1);
		stockBuyOutput.setStatusCode(HttpStatus.CREATED.value());
		
		
		stockbuyModificationInput=new StockbuyModificationInput();
		stockbuyModificationInput.setFlag(1);
		stockbuyModificationInput.setPurchaseId(1);
		stockbuyModificationInput.setQuantity(10);
		stockbuyModificationOutput=new StockbuyModificationOutput();
		stockbuyModificationOutput.setBrokarage(100);
		stockbuyModificationOutput.setCurrentAmount(1000);
		stockbuyModificationOutput.setStatusCode(401);
	}
	
	@Test
	public void stockbuyTest() {
		Mockito.when(stockBuyService.stockbuy(stockBuyInput)).thenReturn(stockBuyOutput);
		
		ResponseEntity<StockBuyOutput> actual = stockBuyController.stockbuy(stockBuyInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCodeValue());
		
	}
	
	@Test
	public void stockbuyModification() {
		
	Mockito.when(stockBuyService.stockbuyModification(stockbuyModificationInput)).thenReturn(stockbuyModificationOutput);
		
		ResponseEntity<StockbuyModificationOutput> actual = stockBuyController.stockbuyModification(stockbuyModificationInput);
		Assert.assertEquals(HttpStatus.CREATED.value(), actual.getStatusCodeValue());
		
		
	}
	
}
