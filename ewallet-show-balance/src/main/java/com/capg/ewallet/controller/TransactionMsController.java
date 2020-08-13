package com.capg.ewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.service.TransactionMsService;

@RestController

public class TransactionMsController {
	
	@Autowired
	TransactionMsService transactionService;
	
	@PostMapping("/addtransaction")
	public WalletTransaction addWalletTransaction(@RequestBody WalletTransaction walletTransaction) {
		return transactionService.addWalletTransaction(walletTransaction);
	}
	
	
	
	
	}