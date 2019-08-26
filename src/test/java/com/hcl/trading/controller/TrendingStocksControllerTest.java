package com.hcl.trading.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.hcl.trading.service.TrendingStocksServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class TrendingStocksControllerTest {

	@Mock
	TrendingStocksServiceImpl trendingStocksServiceImpl;

	@InjectMocks
	TrendingStocksController trendingStocksController;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(trendingStocksController).build();

	}

	@Test
	public void testTrendingList() throws Exception {

		mockMvc.perform(
				MockMvcRequestBuilders.get("/topStocks").contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL))
				.andExpect(status().isOk());

	}

}
