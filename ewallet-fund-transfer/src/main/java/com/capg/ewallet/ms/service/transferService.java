package com.capg.ewallet.ms.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.ms.dao.transferRepo;
import com.capg.ewallet.ms.transfer.WalletAccount;
@Service
public class transferService {

	@Autowired
	private transferRepo repo;
	@Autowired
	WalletAccount walletaccount;
	public WalletAccount transferAmount(int id,double amount)
	{
		 walletaccount=repo.findById(id).orElse(new WalletAccount());
		
	double accountBalance=walletaccount.getAccountBalance();
      accountBalance=accountBalance+amount;
		walletaccount.setAccountBalance(accountBalance);
		repo.save( walletaccount);
		
		return walletaccount;
		
		
	
	
	}

}
