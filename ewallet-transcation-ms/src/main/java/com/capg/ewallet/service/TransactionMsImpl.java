package com.capg.ewallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.ewallet.exception.AccountNotFoundException;
import com.capg.ewallet.exception.InvalidAmountException;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.repo.AccountMsRepo;
import com.capg.ewallet.repo.TransactionsRepo;

@Service
public class TransactionMsImpl implements TransactionMsInterface {
	
	@Autowired
	private Random random;
	
	
	@Autowired
	TransactionsRepo transactionrepo;
	
	@Autowired
	private AccountMsRepo accountMsRepo;
	
		@Autowired
	RestTemplate rt;
	
	
//	public WalletAccount getAllWalletAccount() {
//		WalletAccount walletAccount;
//		
//		//return accountMsRepo.save(walletAccount);
//		
//		return 	null;
//	}
	
	@Override
	public WalletAccount transferAmount(WalletTransaction walletTransaction) throws AccountNotFoundException,InvalidAmountException{
		double fromAccountBalance;
		double toAccountBalace;
		
		if(!accountMsRepo.existsById(walletTransaction.getFromAccountId()) || !accountMsRepo.existsById(walletTransaction.getToAccountId()) )
		{
			throw new AccountNotFoundException("Account Does not Found");
		}
		
      if(walletTransaction.getAccountBalance()<0) {
			
			throw new InvalidAmountException("Account Balance: "+walletTransaction.getAccountBalance()+ "Invalid");
			
		}
	
 WalletAccount fromAccount=rt.getForObject("http://EWALLET-ACCOUNT-MS/ewallet/public/getaccount/id/"+walletTransaction.getFromAccountId(),WalletAccount.class);
 WalletAccount toAccount=rt.getForObject("http://EWALLET-ACCOUNT-MS/ewallet/public/getaccount/id/"+walletTransaction.getToAccountId(),WalletAccount.class);
	
 
    fromAccountBalance=fromAccount.getAccountBalance();
 
    fromAccount.setAccountBalance(fromAccountBalance-walletTransaction.getAmount());
    toAccountBalace=toAccount.getAccountBalance();
 
 
   double newBalanceToAccount=toAccountBalace+walletTransaction.getAmount();
   toAccount.setAccountBalance(toAccountBalace+walletTransaction.getAmount());
 
      accountMsRepo.save(fromAccount);
      accountMsRepo.save(toAccount);


		walletTransaction.setTransactionId(random.nextInt(1000000));
		walletTransaction.setDateOfTransaction(LocalDateTime.now());
		walletTransaction.setAccountBalance(newBalanceToAccount);
		transactionrepo.save(walletTransaction);
		
		if(toAccount.gettHistory()==null) {
			List<WalletTransaction>tlist=new ArrayList<>();
			tlist.add(walletTransaction);
			toAccount.settHistory(tlist);
		}
		else {
		toAccount.gettHistory().add(walletTransaction);
		}
		return toAccount;
		
	}
	
	
	
	@Override
	public WalletTransactionList getAllWalletTransaction() {

		WalletTransactionList list=new WalletTransactionList();
		
		list.setWalletTransaction(transactionrepo.findAll());
		//transactionrepo.findAll();
		return list;
	}


	@Override
	public WalletAccount getAllWalletAccount() {
		// TODO Auto-generated method stub
		//return accountMsRepo.findAll();
		return null;
	}

}
