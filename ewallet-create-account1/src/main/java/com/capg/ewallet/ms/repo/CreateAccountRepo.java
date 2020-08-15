package com.capg.ewallet.ms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.capg.ewallet.ms.model.WalletAccount;
import com.capg.ewallet.ms.model.WalletUser;

public interface CreateAccountRepo extends JpaRepository<WalletUser,Integer> {
	

}
