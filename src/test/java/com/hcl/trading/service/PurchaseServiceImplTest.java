package com.hcl.trading.service;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.hcl.trading.dto.PurchaseDTO;
import com.hcl.trading.entity.Purchase;
import com.hcl.trading.entity.Stock;
import com.hcl.trading.repository.PurchaseRepository;
import com.hcl.trading.repository.StockRepository;

@RunWith(MockitoJUnitRunner.class)
public class PurchaseServiceImplTest {

	@Mock
	PurchaseRepository purchaseRepository;

	@Mock
	StockRepository stockRepository;

	@InjectMocks
	PurchaseServiceImpl purchaseServiceImpl;

	@Test
	public void testPurchasedList() {

		List<Purchase> purchaseList = new ArrayList<>();

		Purchase purchase = new Purchase();

		PurchaseDTO purchaseDTO = null;
		PurchaseDTO purchaseDTO1 = null;

		purchase.setPurchaseId(1);
		purchase.setQuantity(100);
		purchase.setStockId(1);
		purchase.setUserId(1);
		purchase.setAmount(1000);
		purchase.setPurchaseStatus("CONFIRMED");
		purchase.setPurchaseDate(LocalDate.now());

		purchaseList.add(purchase);

		Purchase purchase1 = new Purchase();

		List<PurchaseDTO> purchaseDTOList = new ArrayList<>();

		purchase1.setPurchaseId(1);
		purchase1.setQuantity(100);
		purchase1.setStockId(1);
		purchase1.setUserId(2);
		purchase1.setAmount(1000);
		purchase1.setPurchaseStatus("CONFIRMED");
		purchase1.setPurchaseDate(LocalDate.now());

		purchaseList.add(purchase1);

		Stock stock = new Stock();

		stock.setStockId(1);
		stock.setStockName("HCL");
		stock.setStockPrice(1000);
		stock.setStockQuantity(10);
		stock.setStockSector("IT");

		Mockito.when(purchaseRepository.findByUserIdAndPurchaseStatus(Mockito.anyInt(), Mockito.any()))
				.thenReturn(purchaseList);

		Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));

		purchaseDTO = new PurchaseDTO();
		purchaseDTO.setStockName("HCL");
		purchaseDTO.setQuantity(purchase.getQuantity());
		purchaseDTO.setAmount(purchase.getAmount());
		purchaseDTO.setPurchaseDate(purchase.getPurchaseDate());
		purchaseDTO.setPurchaseStatus(purchase.getPurchaseStatus());

		purchaseDTOList.add(purchaseDTO);

		purchaseDTO1 = new PurchaseDTO();
		purchaseDTO1.setStockName("HCL Technologies");
		purchaseDTO1.setQuantity(purchase.getQuantity());
		purchaseDTO1.setAmount(purchase.getAmount());
		purchaseDTO1.setPurchaseDate(purchase.getPurchaseDate());
		purchaseDTO1.setPurchaseStatus(purchase.getPurchaseStatus());

		purchaseDTOList.add(purchaseDTO1);
		
		List<PurchaseDTO> actualValue=purchaseServiceImpl.purchasedList(1, "CONFIRMED");
		
		assertEquals(purchaseDTOList.size(), actualValue.size());

	}

}
