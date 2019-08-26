package com.hcl.trading.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.trading.dto.StockDetailsDto;
import com.hcl.trading.entity.Stock;
import com.hcl.trading.repository.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	private static final Logger LOGGER = LoggerFactory.getLogger(StockServiceImpl.class);
	
	@Autowired
	StockRepository stockRepository;

	public List<StockDetailsDto> stocks() {
		LOGGER.debug("StockServiceImpl stocks()");
		List<Stock> stocks = stockRepository.findAll();
		List<StockDetailsDto> stockDetailsDtos = new ArrayList<>();
		for (Stock stock : stocks) {
			StockDetailsDto stockDetailsDto = new StockDetailsDto();
			BeanUtils.copyProperties(stock, stockDetailsDto);
			stockDetailsDtos.add(stockDetailsDto);
		}

		return stockDetailsDtos;
	}

}
