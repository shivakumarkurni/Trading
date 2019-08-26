package com.hcl.trading.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.hcl.trading.dto.PurchaseDTO;
import com.hcl.trading.service.PurchaseServiceImpl;

@CrossOrigin(allowedHeaders = { "*", "*/" }, origins = { "*", "*/" })
@RestController
public class PurchaseController {

	@Autowired
	PurchaseServiceImpl purchaseServiceImpl;

	@GetMapping("/purchased/{userId}/status/{flag}")
	public ResponseEntity<List<PurchaseDTO>> purchasedList(@PathVariable Integer userId, @PathVariable String flag) {

		return new ResponseEntity<>(purchaseServiceImpl.purchasedList(userId, flag), HttpStatus.OK);

	}

}
