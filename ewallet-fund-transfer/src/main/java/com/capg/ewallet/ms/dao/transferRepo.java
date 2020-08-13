package com.capg.ewallet.ms.dao;

import org.springframework.data.repository.CrudRepository;

import com.capg.ewallet.ms.transfer.WalletAccount;

public interface transferRepo extends CrudRepository<WalletAccount,Integer> {
	

}
