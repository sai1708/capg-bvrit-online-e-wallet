package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletTransaction;



public interface TransactionsRepo extends JpaRepository<WalletTransaction, Integer>{
	 
	
	

}
