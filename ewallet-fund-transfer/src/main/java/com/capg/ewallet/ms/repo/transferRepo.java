package com.capg.ewallet.ms.repo;

import org.springframework.data.repository.CrudRepository;

import com.capg.ewallet.ms.model.WalletAccount;

public interface transferRepo extends CrudRepository<WalletAccount,Integer> {
	

}
