package com.capg.ewallet.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capg.ewallet.model.TransferData;
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
	public WalletAccount transferAmount(WalletTransaction walletTransaction) {
	
 WalletAccount fromAccount=rt.getForObject("http://localhost:8400/ewallet/getaccount/id/"+walletTransaction.getFromAccountId(),WalletAccount.class);
 WalletAccount toAccount=rt.getForObject("http://localhost:8400/ewallet/getaccount/id/"+walletTransaction.getToAccountId(),WalletAccount.class);
	
 
 double fromAccountBalance=fromAccount.getAccountBalance();
 fromAccount.setAccountBalance(fromAccountBalance-walletTransaction.getAmount());
 double toAccountBalace=toAccount.getAccountBalance();
 
 double newBalanceToAccount=toAccountBalace+walletTransaction.getAmount();
   toAccount.setAccountBalance(toAccountBalace+walletTransaction.getAmount());
 
 accountMsRepo.save(fromAccount);
 accountMsRepo.save(toAccount);

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
		walletTransaction.setTransactionId(random.nextInt(1000000));
		walletTransaction.setDateOfTransaction(LocalDateTime.now());
		walletTransaction.setAccountBalance(newBalanceToAccount);
		transactionrepo.save(walletTransaction);
	//	toAccount.setStatus("Transfered");
	    return toAccount; 
		
	//	return null;
	}
	
	@Override
	public WalletTransactionList getAllWalletTransaction() {

		WalletTransactionList list=new WalletTransactionList();
		
		list.setWalletTransaction(transactionrepo.findAll());
		//transactionrepo.findAll();
		return list;
	}

//	@Override
/*	public WalletAccount transferAmount(TransferData transferdata) {
		WalletAccount fromAccount=rt.getForObject("http://localhost:8400/ewallet/getaccount/id/"+transferdata.getFromAccountId(),WalletAccount.class);
		WalletAccount toAccount=rt.getForObject("http://localhost:8400/ewallet/getaccount/id/"+transferdata.getToAccountId(),WalletAccount.class);
		 double fromAccountBalance=fromAccount.getAccountBalance();
		 fromAccount.setAccountBalance(fromAccountBalance-transferdata.getAmount());
		 double toAccountBalace=toAccount.getAccountBalance();
		 toAccount.setAccountBalance(toAccountBalace+transferdata.getAmount());
		 
		 accountMsRepo.save(fromAccount);
		 accountMsRepo.save(toAccount);  */
		 
//		 WalletTransactions walletTransactions=new WalletTransactions();
//		 
//		 //walletTransactions.setAccountId(fromAccount.getAccountId());
//		 walletTransactions.setTransactionId(random.nextInt(1000));
//		 walletTransactions.setDescription("Transfered");
//         walletTransactions.setDateOfTransaction(LocalDateTime.now());
//       //  walletTransactions.setDescription("Transfered");
//         walletTransactions.setAmount(transferdata.getAmount());
//         walletTransactions.setAccountBalance(toAccount.getAccountBalance());
//         
   //     WalletTransactions walletTransactions2=new WalletTransactions();
//         //walletTransactions2.setAccountId(toAccount.getAccountId());
    /*     walletTransactions2.setTransactionId(random.nextInt(1000));
         walletTransactions2.setDateOfTransaction(LocalDateTime.now());
         walletTransactions2.setDescription("Credited");
         walletTransactions2.setAmount(transferdata.getAmount());
         walletTransactions2.setAccountBalance(toAccount.getAccountBalance());  */
		 
   //      transactionrepo.save(walletTransactions);
   //     transactionrepo.save(walletTransactions2);
         
//         rt.put("http://localhost:8400/ewallet/update", fromAccount);
//         rt.put("http://localhost:8400/ewallet/update", toAccount);
//         
 //   	return toAccount;
//		
////		return null;
//	}

//	@Override
//	public WalletAccount fundtransfer(WalletTransactions walletTransactions) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public WalletAccount getAllWalletAccount() {
		// TODO Auto-generated method stub
		//return accountMsRepo.findAll();
		return null;
	}

}
