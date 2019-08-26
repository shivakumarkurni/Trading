package com.hcl.trading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.TrendingStocksDTO;
import com.hcl.trading.service.TrendingStocksServiceImpl;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class TrendingStocksController {

	@Autowired
	TrendingStocksServiceImpl trendingStocksServiceImpl;

	@GetMapping("/topStocks")
	public ResponseEntity<List<TrendingStocksDTO>> trendingList() {

		return new ResponseEntity<>(trendingStocksServiceImpl.trendingStocks(), HttpStatus.OK);
	}

}
