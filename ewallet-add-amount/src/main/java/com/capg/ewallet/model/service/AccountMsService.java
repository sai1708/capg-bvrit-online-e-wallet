package com.capg.ewallet.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.repo.AccountMsRepo;

@Service
public class AccountMsService {
	
	@Autowired
	private AccountMsRepo accountMsRepo;

	public WalletAccount addWalletAccount(WalletAccount walletAccount) {
		// TODO Auto-generated method stub
		return accountMsRepo.save(walletAccount);

	}

	public WalletAccount getAccountById(int id) {
		// TODO Auto-generated method stub
		
		return accountMsRepo.getOne(id);
	}
	
	public WalletAccount addAmount(WalletAccount walletAccount) {
		// TODO Auto-generated method stub
		WalletAccount account=accountMsRepo.getOne(walletAccount.getAccountId());
	    double newamount=account.getAccountBalance()+walletAccount.getAccountBalance();
		account.setAccountBalance(newamount);
		return accountMsRepo.save(account);	
	
	}

	
}
