package com.capg.ewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.service.AccountMsService;

@RestController
@RequestMapping("/add")
public class AccountMsController {
	
	@Autowired
	AccountMsService accountService;
	
	@PostMapping("/addaccount")
	public WalletAccount addWalletAccount(@RequestBody WalletAccount walletAccount) {
		return accountService.addWalletAccount(walletAccount);
	}
	
	@PostMapping("/addamount")
	public WalletAccount addAmount(@RequestBody WalletAccount walletAccount) {
		return accountService.addAmount(walletAccount);
	}
	
	
	}
   
	
	


