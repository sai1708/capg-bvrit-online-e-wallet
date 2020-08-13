package com.capg.ewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.service.AccountMsServiceImpl;

@RestController
@RequestMapping("/add")
public class AccountMsController {
	
	@Autowired
	AccountMsServiceImpl accountService;
	
	@PostMapping("/addaccount")
	public WalletAccount addWalletAccount(@RequestBody WalletAccount walletAccount) throws AccountAlreadyExistsException, InvalidAmountException {
		return accountService.addWalletAccount(walletAccount);
	}
	
	@PostMapping("/addamount")
	public WalletAccount addAmount(@RequestBody WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException  {
		return accountService.addAmount(walletAccount);
	}
	
	
	}
   
	
	


