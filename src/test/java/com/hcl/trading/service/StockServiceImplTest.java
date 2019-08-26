package com.hcl.trading.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.trading.dto.StockDetailsDto;
import com.hcl.trading.entity.Stock;
import com.hcl.trading.repository.StockRepository;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class StockServiceImplTest {
	
	@Mock
	StockRepository stockRepository;
	
	@InjectMocks
	StockServiceImpl stockService;
	
	StockDetailsDto stockDetailsDto = null;
	List<StockDetailsDto> stockDetailsDtos = null;
	Stock stock = null;
	List<Stock> stocks = null;
	
	@Before
	public void setup() {
		stockDetailsDto = new StockDetailsDto();
		stockDetailsDto.setStockName("HCL");
		
		stockDetailsDtos = new ArrayList<StockDetailsDto>();
		stockDetailsDtos.add(stockDetailsDto);
		
		stock = new Stock();
		stocks  = new ArrayList<>();
		
		stock.setStockId(1);
		
		stocks.add(stock);
	}

	@Test
	public void stocksTest() {
		Mockito.when(stockRepository.findAll()).thenReturn(stocks);
		List<StockDetailsDto> usResponseEntity = stockService.stocks();
		assertEquals(1, usResponseEntity.size());
	}
	

}
