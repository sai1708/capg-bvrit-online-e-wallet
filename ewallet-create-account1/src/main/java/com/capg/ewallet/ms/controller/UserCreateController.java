package com.capg.ewallet.ms.controller;


import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.servlet.ModelAndView;

//import com.capg.ewallet.ms.model.WalletAccount;
import com.capg.ewallet.ms.model.WalletUser;
//import com.capg.ewallet.ms.repo.CreateAccountRepo;
import com.capg.ewallet.ms.service.WalletService;


@RestController

@RequestMapping("/wallet")
public class UserCreateController {
	  
    @Autowired
    WalletService service;

	@PostMapping("/add")
	public WalletUser createWalletAccount(@RequestBody WalletUser walletuser) {
		
	 return  service.addAccount(walletuser);
		
			}
}


