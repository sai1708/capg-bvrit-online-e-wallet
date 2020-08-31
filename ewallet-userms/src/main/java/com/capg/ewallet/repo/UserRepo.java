package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;

public interface UserRepo extends JpaRepository<WalletUser, Integer>{

	public WalletUser findByUserIdAndPassword(int userId,String password);
    
	public WalletUser findByUserId(int userId);

}
