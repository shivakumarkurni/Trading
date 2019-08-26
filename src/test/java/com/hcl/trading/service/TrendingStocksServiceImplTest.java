package com.hcl.trading.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trading.dto.TrendingStocksDTO;
import com.hcl.trading.repository.PurchaseRepository;

@RunWith(MockitoJUnitRunner.class)
public class TrendingStocksServiceImplTest {

	@Mock
	PurchaseRepository purchaseRepository;

	@InjectMocks
	TrendingStocksServiceImpl trendingStocksServiceImpl;

	@Test
	public void testTrendingStocks() {

		List<TrendingStocksDTO> trendingStocksList = new ArrayList<>();

		TrendingStocksDTO trendingStocksDTO = new TrendingStocksDTO();

		trendingStocksDTO.setCount(1L);
		trendingStocksDTO.setStockId(1);
		trendingStocksDTO.setStockName("HCL");

		TrendingStocksDTO trendingStocksDTO1 = new TrendingStocksDTO();

		trendingStocksDTO1.setCount(2L);
		trendingStocksDTO1.setStockId(2);
		trendingStocksDTO1.setStockName("Reliance Industries");

		Mockito.when(purchaseRepository.findByPurchaseStatus(Mockito.anyString())).thenReturn(trendingStocksList);

		List<TrendingStocksDTO> actualValue = trendingStocksServiceImpl.trendingStocks();

		assertEquals(trendingStocksList.size(), actualValue.size());

	}

}
