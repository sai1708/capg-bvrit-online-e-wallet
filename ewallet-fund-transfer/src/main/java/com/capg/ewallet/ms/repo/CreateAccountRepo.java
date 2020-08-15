package com.capg.ewallet.ms.repo;

import org.springframework.data.repository.CrudRepository;

import com.capg.ewallet.ms.model.WalletAccount;
import com.capg.ewallet.ms.model.WalletUser;

public interface CreateAccountRepo extends CrudRepository<WalletUser,Integer> {
	

}
