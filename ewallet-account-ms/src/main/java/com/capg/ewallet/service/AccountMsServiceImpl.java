package com.capg.ewallet.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
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
	
	// Tells the application context to inject an instance of AccountMsRepo here
	@Autowired
	private AccountMsRepo accountMsRepo;
	
	@Autowired
	private Random random;
	
	@Autowired
	RestTemplate rt;
	
	// Tells the application context to inject an instance of TransactionsRepo here
	@Autowired
	TransactionsRepo transactionrepo;
	
	// Tells the application context to inject an instance of UserRepo here
	@Autowired
	UserRepo userRepo;
	
	
	 /**
     * This method is used to add an account. 
    * @return   WalletAccount : This returns the account
    * an exception which is handled globally
     */
 
	@Transactional
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
	

	  /**
      * This method is used to adding amount to existing account. 
     * @param accountId,accountBalance  :This are the  paramters to add the amount into account
     * @return   WalletAccount : This returns the accountId,Balance 
     * an exception which is handled globally
      */
	  
      @Transactional
      public WalletAccount addAmount(WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException {
		
		if(!accountMsRepo.existsById(walletAccount.getAccountId())) {
			throw new AccountNotFoundException("Account with id: "+walletAccount.getAccountId() +" Does not Exist ");
		}
		
        if(walletAccount.getAccountBalance()<0) {
			throw new InvalidAmountException("Account Balance: "+walletAccount.getAccountBalance()+ "Invalid");	
		}
        
  
		
		WalletAccount userAccount=rt.getForObject("http://EWALLET-USERMS/users/public/getaccount/id/"+walletAccount.getAccountId(), WalletAccount.class);
		
		double newBalance=userAccount.getAccountBalance()+walletAccount.getAccountBalance();
		
		userAccount.setAccountBalance(newBalance);
		
		//accountMsRepo.save(userAccount);
		
		WalletTransaction walletTransaction= new WalletTransaction();
		
		 walletTransaction.setTransactionId(random.nextInt(1000000));
	     walletTransaction.setDateOfTransaction(LocalDateTime.now());
	     walletTransaction.setFromAccountId(0);
		 walletTransaction.setToAccountId(userAccount.getAccountId());
		 walletTransaction.setAccountBalance(newBalance);
		 walletTransaction.setDescription("Added");
		 walletTransaction.setAmount(walletAccount.getAccountBalance());
		//transactionrepo.save(walletTransaction);
		//System.out.println(walletTransaction);
	//	System.out.println(userAccount);
		if(userAccount.gettHistory()==null) {
			List<WalletTransaction>tlist=new ArrayList<>();
			tlist.add(walletTransaction);
			userAccount.settHistory(tlist);
			
		}
		else {
		userAccount.gettHistory().add(walletTransaction);

		}
		transactionrepo.save(walletTransaction);
		
		//System.out.println(userAccount);
		accountMsRepo.save(userAccount);
		
		return userAccount;
		
	}
	
	
      /**
       * This method is used to get all WalletTranactionDetails. 
      * @return   WalletTransactionList : This returns all the transactions 
    
       */
	
	
	@Override
	public WalletTransactionList getAllWalletTransaction() {
		// TODO Auto-generated method stub
		
		WalletTransactionList walletTransaction=rt.getForObject("http://EWALLET-TRANSCATION-MS/transaction/public/getalltransaction", WalletTransactionList.class);

		return walletTransaction;
		
	}
	
	 /**
     * This method is used to get all WalletAccounts.  
    * @return List<WalletAccount> : This returns List of wallet Accounts
    * an exception which is handled globally
     */

	@Override
	public List<WalletAccount> getAllWalletAccount() throws AccountNotFoundException {
		// TODO Auto-generated method stub
		if(accountMsRepo.findAll().isEmpty())
		{
			throw new AccountNotFoundException("None are available");
		}
		return accountMsRepo.findAll();
	}
    
	 /**
     * This method is used to get one wallet account. 
    * @param accountId:This is the  paramters to get one wallet account
    * @return   WalletAccount : This returns the WalletAccount
    * an exception which is handled globally
     */
	@Override
	public WalletAccount getOneWalletAccount(int accountId) throws AccountNotFoundException {
		// TODO Auto-generated method stub
		if(!accountMsRepo.existsById(accountId)) {
			throw new AccountNotFoundException("Account Not Found");
		}
		return accountMsRepo.getOne(accountId);
	}
	 /**
     * This method is used to get list of transactions by using accountId
    * @param accountId :This is the  paramter is used to get OneWalletTransaction
    * @return  List<WalletTransaction> : This returns the transaction details of particular account by accountId
     */
	
	@Override
	public List<WalletTransaction> getOneWalletTransaction(int accountId) {
		// TODO Auto-generated method stub
		WalletAccount wa=accountMsRepo.getOne(accountId);
		return wa.gettHistory();
		//return transactionrepo.getOne(accountId);
	}

		
}
