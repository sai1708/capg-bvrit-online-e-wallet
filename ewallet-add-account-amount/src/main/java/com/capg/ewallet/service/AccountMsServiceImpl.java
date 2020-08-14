package com.capg.ewallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransactions;
import com.capg.ewallet.repo.AccountMsRepo;
//import com.capg.ewallet.repo.TransactionsRepo;

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
	
	
//	@Override
//	public WalletAccount fundtransfer(double amount, int fromAccountId, int toAccountId) {
//		// TODO Auto-generated method stub
//		WalletAccount fromAccount=accountMsRepo.getOne(fromAccountId);
//		WalletAccount toAccount=accountMsRepo.getOne(toAccountId);
//		double fromBalance=fromAccount.getAccountBalance();
//		double toBalance=toAccount.getAccountBalance();
//		double newBalance=fromBalance-amount;
//		double newBalanceToAccount=toBalance+amount;
//		fromAccount.setAccountBalance(newBalance);
//		toAccount.setAccountBalance(newBalanceToAccount);
//		accountMsRepo.save(fromAccount);
//		accountMsRepo.save(toAccount);
//		return toAccount;
//	}

	@Override
	public WalletAccount fundtransfer(TransferData transferData) {
		// TODO Auto-generated method stub
		WalletAccount fromAccount=accountMsRepo.getOne(transferData.getFromAccountId());
		WalletAccount toAccount=accountMsRepo.getOne(transferData.getToAccountId());
		double toBalance=toAccount.getAccountBalance();
		double fromBalance=fromAccount.getAccountBalance();
		double newBalance=fromBalance-transferData.getAmount();
		double newBalanceToAccount=toBalance+transferData.getAmount();
		fromAccount.setAccountBalance(newBalance);
		toAccount.setAccountBalance(newBalanceToAccount);
		
		accountMsRepo.save(fromAccount);
		accountMsRepo.save(toAccount);
		toAccount.setStatus(transferData.getStatus());
		
		return toAccount;
	}
	
//	@Autowired
//	TransactionsRepo transactionrepo;
//	
//	public WalletTransactions createBasicTransaction() {
//		WalletTransactions transaction=new WalletTransactions();
//		Random r=new Random();
//		LocalDateTime now=LocalDateTime.now();
//		int transactionId=r.nextInt(1000);
//		transaction.setTransactionId(transactionId);
//		transaction.setDateOfTransaction(now);
//		return transactionrepo.save(transaction);
//		
//	}


		
}
