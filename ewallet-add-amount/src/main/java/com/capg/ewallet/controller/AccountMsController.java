package com.capg.ewallet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.service.AccountMsService;

@RestController
//@RequestMapping("/addaccount")
public class AccountMsController {
	
	@Autowired
	AccountMsService accountMsService;
	
	@PostMapping("/add")
	public WalletAccount addWalletAccount(@RequestBody WalletAccount walletaccount) {
		return accountMsService.addWalletAccount(walletaccount);
	}
	
   
	
	

}
