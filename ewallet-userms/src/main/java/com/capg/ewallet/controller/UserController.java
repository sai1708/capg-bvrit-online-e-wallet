package com.capg.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	
	
	@PostMapping("/createaccount")
	public WalletUser createWalletUser(@RequestBody WalletUser walletUser) {
		return userService.createWalletUser(walletUser);
		
	}
	
	@GetMapping("/getalluser")
	public List<WalletUser> getAllWalletUser(){
		return userService.getAllWalletUser();	
	}
	
	@GetMapping("/getaccount/id/{id}")
	public WalletAccount getOneAccount(@PathVariable ("id") int accountId) {
		return userService.getOneAccount(accountId);
		
	}

}
