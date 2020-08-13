package com.capg.ewallet.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.errors.AccountNotFoundException;
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

//	public WalletAccount getAccountById(int id) {
//		// TODO Auto-generated method stub
//		
//		return accountMsRepo.getOne(id);
//	}
	
	public WalletAccount addAmount(WalletAccount walletAccount) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		if(!accountMsRepo.existsById(walletAccount.getAccountId())) {
			throw new AccountNotFoundException("Account with id: "+walletAccount.getAccountId() +" Does not Exist ");
		}
		WalletAccount account=accountMsRepo.getOne(walletAccount.getAccountId());
	    double newamount=account.getAccountBalance()+walletAccount.getAccountBalance();
		account.setAccountBalance(newamount);
		return accountMsRepo.save(account);	
	
	}

	
}
