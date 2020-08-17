package com.capg.ewallet.ms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.ms.model.WalletUser;
import com.capg.ewallet.ms.repo.CreateAccountRepo;

@Service
public class WalletService {
	@Autowired
	 CreateAccountRepo repo;
	public WalletUser addAccount(WalletUser walletuser) {
		return repo.save(walletuser);
		
	}

}
