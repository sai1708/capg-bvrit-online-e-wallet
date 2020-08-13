package com.capg.ewallet.ms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.capg.ewallet.ms.service.transferService;
import com.capg.ewallet.ms.transfer.WalletAccount;

@RestController

public class FundTransferController {
	@Autowired
	private transferService service;
	@Autowired
	WalletAccount walletaccount;
	@RequestMapping("/transfer/{transactionId}{amount}")
		
	public ModelAndView transfer(int transactionId,double amount) {
		
	walletaccount=service.transferAmount(transactionId,amount);
	ModelAndView mv=new ModelAndView("home.jsp");
	mv.addObject(walletaccount);
	return mv;
		
			}
}


