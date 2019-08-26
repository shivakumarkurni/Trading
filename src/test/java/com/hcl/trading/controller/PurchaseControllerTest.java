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

import com.hcl.trading.service.PurchaseServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseControllerTest {

	@Mock
	PurchaseServiceImpl purchaseServiceImpl;

	@InjectMocks

	PurchaseController purchaseController;

	MockMvc mockMvc;

	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build();

	}

	@Test
	public void testPurchasedList() throws Exception {

		mockMvc.perform(MockMvcRequestBuilders.get("/purchased/1/status/CONFIRMED")
				.contentType(MediaType.APPLICATION_JSON).accept(MediaType.ALL)).andExpect(status().isOk());
	}

}
