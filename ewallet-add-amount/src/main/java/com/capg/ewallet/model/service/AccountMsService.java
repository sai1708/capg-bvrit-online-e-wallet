package com.capg.ewallet.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.repo.AccountMsRepo;

@Service
public class AccountMsService {
	
	@Autowired
	private AccountMsRepo accountMsRepo;

	public WalletAccount addWalletAccount(WalletAccount walletaccount) {
		// TODO Auto-generated method stub
		return accountMsRepo.save(walletaccount);

	}

}
