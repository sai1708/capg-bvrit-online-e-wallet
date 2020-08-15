package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.WalletAccount;


public interface AccountMsRepo extends JpaRepository<WalletAccount, Integer> {

	

}
