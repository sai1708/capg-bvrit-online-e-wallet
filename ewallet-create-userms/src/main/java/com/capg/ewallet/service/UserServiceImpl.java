package com.capg.ewallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.repo.AccountMsRepo;
import com.capg.ewallet.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AccountMsRepo accountMsRepo;

	@Override
	public WalletUser createWalletUser(WalletUser walletUser) {
		// TODO Auto-generated method stub
		return userRepo.save(walletUser);
	}

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public WalletAccount getOneAccount(int accountId) {
		// TODO Auto-generated method stub
		return accountMsRepo.getOne(accountId);
	}

}
