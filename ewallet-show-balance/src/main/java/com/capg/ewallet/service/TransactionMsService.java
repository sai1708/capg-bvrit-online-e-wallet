package com.capg.ewallet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.repo.TransactionMsRepo;

@Service
public class TransactionMsService {
	
	@Autowired
	private TransactionMsRepo transactionMsRepo;

	public WalletTransaction addwalletTransaction(WalletTransaction walletTransaction) {
		// TODO Auto-generated method stub
		return transactionMsRepo.save(walletTransaction);

		

	}

	public WalletTransaction addWalletTransaction(WalletTransaction walletTransaction) {
		// TODO Auto-generated method stub
		return null;
	}

}
