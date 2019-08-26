package com.hcl.trading.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.StockDetailsDto;
import com.hcl.trading.service.StockService;

@RestController
@RequestMapping("/trading")
@CrossOrigin(origins = {"*","*/"},allowedHeaders = {"*","*/"})
public class StockController {

	@Autowired
	StockService stockService;

	private static final Logger LOGGER = LoggerFactory.getLogger(StockController.class);

	@GetMapping("/stocks")
	public ResponseEntity<List<StockDetailsDto>> stocks() {
		LOGGER.debug("StockController stocks()");
		List<StockDetailsDto> stockDetailsDtos = stockService.stocks();
		return new ResponseEntity<>(stockDetailsDtos, HttpStatus.OK);
	}
}
