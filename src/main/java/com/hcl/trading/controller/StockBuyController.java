package com.hcl.trading.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.StockBuyInput;
import com.hcl.trading.dto.StockBuyOutput;
import com.hcl.trading.dto.StockbuyModificationInput;
import com.hcl.trading.dto.StockbuyModificationOutput;
import com.hcl.trading.service.StockBuyService;



@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class StockBuyController {
	
	@Autowired StockBuyService stockBuyService;
	
	
	@PostMapping("/stock")
	public ResponseEntity<StockBuyOutput> stockbuy(@RequestBody StockBuyInput stockBuyInput) {
		return ResponseEntity.status(HttpStatus.CREATED).body(stockBuyService.stockbuy(stockBuyInput));
		
	}
	
	@PutMapping("/stock")
	public ResponseEntity<StockbuyModificationOutput> stockbuyModification(@RequestBody StockbuyModificationInput stockbuyModificationInput) {
		return ResponseEntity.status(HttpStatus.CREATED).body(stockBuyService.stockbuyModification(stockbuyModificationInput));
		
	}




}
