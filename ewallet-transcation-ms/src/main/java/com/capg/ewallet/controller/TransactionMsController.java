package com.capg.ewallet.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.ewallet.exception.AccountNotFoundException;
import com.capg.ewallet.exception.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.service.TransactionMsInterface;

@RestController
@RequestMapping("/ewallet")
public class TransactionMsController {
	
	@Autowired
	RestTemplate rt;
	
	@Autowired
	TransactionMsInterface transactionMs;
	
	@GetMapping("/getaccount")
	public WalletAccount getAllWalletAccount(){
		return transactionMs.getAllWalletAccount();
	}
		
	@PostMapping("/transfer")
	public WalletAccount transferAmount(@RequestBody WalletTransaction walletTransaction) throws AccountNotFoundException, InvalidAmountException {
		return  transactionMs.transferAmount(walletTransaction);
	}	
	
	
	
//	@PostMapping("/transfer")
//	public WalletAccount TransferAmount(@RequestBody TransferData transferdata) {
//		return  transactionMs.transferAmount(transferdata);
//		
//		
//	}
	
	@GetMapping("/getalltransaction")
	public WalletTransactionList getAllWalletTransaction(){
		return transactionMs.getAllWalletTransaction();
	}
}
