package com.capg.ewallet.ms.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capg.ewallet.ms.model.WalletAccount;
import com.capg.ewallet.ms.model.WalletUser;
import com.capg.ewallet.ms.repo.CreateAccountRepo;


@RestController

public class UserCreateController {
	@Autowired
	private CreateAccountRepo repo;
	@Autowired
	WalletUser walletuser;
	@RequestMapping("/createaccount/walletuser")
		
	@PostMapping("/add")
	public String transfer(WalletUser walletuser) {
		
	repo.save(walletuser);

	
			
	return "created successfully";
		
			}
}


