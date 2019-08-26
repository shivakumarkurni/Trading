package com.hcl.trading.controller;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.hcl.trading.dto.StockDetailsDto;
import com.hcl.trading.service.StockService;

@RunWith(value = SpringJUnit4ClassRunner.class)
public class StockControllerTest {

	@Mock
	StockService stockService;
	
	@InjectMocks
	StockController stockController;
	
	StockDetailsDto stockDetailsDto = null;
	List<StockDetailsDto> stockDetailsDtos = null;
	
	@Before
	public void setup() {
		stockDetailsDto = new StockDetailsDto();
		stockDetailsDto.setStockName("HCL");
		
		stockDetailsDtos = new ArrayList<StockDetailsDto>();
		stockDetailsDtos.add(stockDetailsDto);
	}

	@Test
	public void stocksTest() {
		Mockito.when(stockService.stocks()).thenReturn(stockDetailsDtos);
		ResponseEntity<List<StockDetailsDto>> usResponseEntity = stockController.stocks();
		List<StockDetailsDto> stockDetailsDtos = usResponseEntity.getBody();
		assertEquals(stockDetailsDtos.toString(), stockDetailsDtos.toString());
		assertEquals(1, stockDetailsDtos.size());
	}
	
}
