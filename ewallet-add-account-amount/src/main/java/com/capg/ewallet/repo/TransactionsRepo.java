package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletTransactions;



public interface TransactionsRepo extends JpaRepository<WalletTransactions, Integer>{
	
	

}
