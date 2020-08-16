package com.capg.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.service.AccountMsService;


@RestController
@RequestMapping("/ewallet")
public class AccountMsController {
	
	@Autowired
	AccountMsService accountMsService;
	
	@PostMapping("/addaccount")
	public WalletAccount addWalletAccount(@RequestBody WalletAccount walletAccount) throws AccountAlreadyExistsException, InvalidAmountException {
		return accountMsService.addWalletAccount(walletAccount);
	}
	
//	@PostMapping("/addamount")
//	public WalletAccount addAmount(@RequestBody WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException  {
//		return accountMsService.addAmount(walletAccount);
//	}
	
//	@PostMapping("/addamount")
///	public WalletUser addAmount(@RequestBody WalletAccount walletAccount) {
//		return accountMsService.addAmount(walletAccount);
//	}
	
	@PostMapping("/addamount")
	public WalletAccount addAmount(@RequestBody WalletAccount walletAccount){
		return accountMsService.addAmount(walletAccount);
	}
	

	
	@GetMapping("/getallaccount")
	public List<WalletAccount> getAllWalletAccount(){
		return accountMsService.getAllWalletAccount();
		
		
	}
	
	@GetMapping("/getaccount/id/{id}")
	public WalletAccount getOneWalletAccount(@PathVariable ("id") int accountId){
		return accountMsService.getOneWalletAccount(accountId);
		
		
	}
	
	
	@GetMapping("/getalltransaction")
	public WalletTransactionList getAllWalletTransaction(){
		return accountMsService.getAllWalletTransaction();
	}
	
	
//	@PutMapping("/update")
//		public WalletAccount updateWalletAccount(@RequestBody WalletAccount walletAccount) {
//		return accountMsService.updateWalletAccount(walletAccount);
//	}
	
	
//	@PutMapping("/account/id/{fromId}/id/{toId}/amount/{amount}")
//	public WalletAccount fundTransfer(@PathVariable ("fromId") int fromAccountId,@PathVariable ("toId") int toAccountId, @PathVariable double amount) {
//		return accountMsService.fundtransfer(amount, fromAccountId, toAccountId);
//		
//
//	}
	
//	@PutMapping("/account/id/{fromId}/id")
//	public WalletAccount fundTransfer(@PathVariable ("fromId") int fromAccountId, @RequestBody WalletAccount walletAccount) {
//		return walletAccount;
//		
//	}
	
//	@PostMapping("/transfer")
//	public WalletAccount fundTransfer(@RequestBody WalletTransactions walletTransactions) {
//		return accountMsService.fundtransfer(walletTransactions);
//		
//		
//	}
	
	
	}
   
	
	


