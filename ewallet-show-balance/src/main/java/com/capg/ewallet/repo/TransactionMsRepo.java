package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.WalletTransaction;

public interface TransactionMsRepo extends JpaRepository<WalletTransaction, Integer> {

	

}
