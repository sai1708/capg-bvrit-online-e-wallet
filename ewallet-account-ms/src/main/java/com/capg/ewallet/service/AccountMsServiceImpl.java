package com.capg.ewallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.repo.AccountMsRepo;
import com.capg.ewallet.repo.TransactionsRepo;
import com.capg.ewallet.repo.UserRepo;
//import com.capg.ewallet.repo.TransactionsRepo;

@Service
public class AccountMsServiceImpl implements AccountMsService {
	
	@Autowired
	private AccountMsRepo accountMsRepo;
	@Autowired
	private Random random;
	
	@Autowired
	RestTemplate rt;
	
	
	@Autowired
	TransactionsRepo transactionrepo;
	
	@Autowired
	UserRepo userRepo;

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

//	public WalletAccount addAmount(WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException {
//		// TODO Auto-generated method stub
//		if(!accountMsRepo.existsById(walletAccount.getAccountId())) {
//			throw new AccountNotFoundException("Account with id: "+walletAccount.getAccountId() +" Does not Exist ");
//		}
//		
//        if(walletAccount.getAccountBalance()<0) {
//			throw new InvalidAmountException("Account Balance: "+walletAccount.getAccountBalance()+ "Invalid");	
//		}
//        
//		WalletAccount account=accountMsRepo.getOne(walletAccount.getAccountId());
//	    double newamount=account.getAccountBalance()+walletAccount.getAccountBalance();
//		account.setAccountBalance(newamount);
//		return accountMsRepo.save(account);	
//	
//	}
	
	
//	public WalletUser addAmount(WalletAccount walletAccount) {
//		
//		WalletUser userAccount=rt.getForObject("http://localhost:8300/ewallet/getaccount/id/"+walletAccount.getAccountId(), WalletUser.class);
//		
//		WalletAccount walletAcc=userAccount.getWalletAccount();
//		
//		double balance= walletAcc.getAccountBalance();
//		
//		double newBalance=walletAccount.getAccountBalance()+balance;
//		
//		walletAcc.setAccountBalance(newBalance);
//		userAccount.setWalletAccount(walletAcc);
//		
//	     userRepo.save(userAccount);
//		
//	     return userAccount;
//	     
//	}
	public WalletAccount addAmount(WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException {
		
		if(!accountMsRepo.existsById(walletAccount.getAccountId())) {
			throw new AccountNotFoundException("Account with id: "+walletAccount.getAccountId() +" Does not Exist ");
		}
		
        if(walletAccount.getAccountBalance()<0) {
			throw new InvalidAmountException("Account Balance: "+walletAccount.getAccountBalance()+ "Invalid");	
		}
		
		WalletAccount userAccount=rt.getForObject("http://localhost:8300/ewallet/getaccount/id/"+walletAccount.getAccountId(), WalletAccount.class);
		
		double newBalance=userAccount.getAccountBalance()+walletAccount.getAccountBalance();
		
		userAccount.setAccountBalance(newBalance);
		
		accountMsRepo.save(userAccount);
		
		return userAccount;
		
	}
	
	
	
	
	
	@Override
	public WalletTransactionList getAllWalletTransaction() {
		// TODO Auto-generated method stub
		
		WalletTransactionList walletTransaction=rt.getForObject("http://localhost:8500/ewallet/getalltransaction", WalletTransactionList.class);

		return walletTransaction;
		
	}

	@Override
	public List<WalletAccount> getAllWalletAccount() {
		// TODO Auto-generated method stub
		return accountMsRepo.findAll();
	}

	@Override
	public WalletAccount getOneWalletAccount(int accountId) {
		// TODO Auto-generated method stub
		return accountMsRepo.getOne(accountId);
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

//	@Override
//	public WalletAccount fundtransfer(WalletTransactions walletTransactions) {
//		// TODO Auto-generated method stub
//		
//		//int transactionId=transferData.getTransactionId();
//		String description=walletTransactions.getDescription();
//		WalletAccount fromAccount=accountMsRepo.getOne(walletTransactions.getFromAccountId());
//		WalletAccount toAccount=accountMsRepo.getOne(walletTransactions.getToAccountId());
//		double toBalance=toAccount.getAccountBalance();
//		double fromBalance=fromAccount.getAccountBalance();
//		double newBalance=fromBalance-walletTransactions.getAmount();
//		double newBalanceToAccount=toBalance+walletTransactions.getAmount();
//		fromAccount.setAccountBalance(newBalance);
//		toAccount.setAccountBalance(newBalanceToAccount);
//		accountMsRepo.save(fromAccount);
//		accountMsRepo.save(toAccount);
//		walletTransactions.setTransactionId(random.nextInt(1000000));
//		walletTransactions.setDateOfTransaction(LocalDateTime.now());
//		
//		walletTransactions.setAccountBalance(newBalanceToAccount);
//		transactionrepo.save(walletTransactions);
//		return toAccount;
//	}

	

//	@Override
//	public WalletAccount updateWalletAccount(WalletAccount walletAccount) {
//		// TODO Auto-generated method stub
//		
//		
//		return accountMsRepo.save(walletAccount);
//	}
	
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
