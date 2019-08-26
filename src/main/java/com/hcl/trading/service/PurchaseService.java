package com.hcl.trading.service;

import java.util.List;

import com.hcl.trading.dto.PurchaseDTO;

public interface PurchaseService {
	
	
	public List<PurchaseDTO> purchasedList(Integer userId,String status);

}
