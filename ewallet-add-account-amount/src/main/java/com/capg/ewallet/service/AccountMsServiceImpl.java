package com.capg.ewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.repo.AccountMsRepo;

@Service
public class AccountMsServiceImpl implements AccountMsService {
	
	@Autowired
	private AccountMsRepo accountMsRepo;

	public WalletAccount addWalletAccount(WalletAccount walletAccount) throws AccountAlreadyExistsException, InvalidAmountException{
		// TODO Auto-generated method stub
		
		if(accountMsRepo.existsById(walletAccount.getAccountId())) {
			
			throw new AccountAlreadyExistsException("Account with id: "+walletAccount.getAccountId() +" Already Exist ");
			
		}
		if(walletAccount.getAccountBalance()<0) {
			
			throw new InvalidAmountException("Account Balance: "+walletAccount.getAccountBalance()+ "Invalid");
			
		}
		return accountMsRepo.save(walletAccount);

	}

	public WalletAccount addAmount(WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException {
		// TODO Auto-generated method stub
		if(!accountMsRepo.existsById(walletAccount.getAccountId())) {
			throw new AccountNotFoundException("Account with id: "+walletAccount.getAccountId() +" Does not Exist ");
		}
		
        if(walletAccount.getAccountBalance()<0) {
			throw new InvalidAmountException("Account Balance: "+walletAccount.getAccountBalance()+ "Invalid");	
		}
        
		WalletAccount account=accountMsRepo.getOne(walletAccount.getAccountId());
	    double newamount=account.getAccountBalance()+walletAccount.getAccountBalance();
		account.setAccountBalance(newamount);
		return accountMsRepo.save(account);	
	
	}
		
}
