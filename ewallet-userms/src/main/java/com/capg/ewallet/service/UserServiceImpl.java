package com.capg.ewallet.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.UserAlreadyExistsException;
import com.capg.ewallet.errors.UserNotFoundException;
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
	public WalletUser createWalletUser(WalletUser walletUser) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		
		if(userRepo.existsById(walletUser.getUserId())) {
			throw new UserAlreadyExistsException("user already exists");
		}
		return userRepo.save(walletUser);
	}

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public WalletAccount getOneAccount(int accountId) throws AccountNotFoundException{
		// TODO Auto-generated method stub
		if(!accountMsRepo.existsById(accountId)) {
			throw new AccountNotFoundException("account does not exist");
		}
		return accountMsRepo.getOne(accountId);
	}

	@Override
	public WalletUser getUser(int userId, String password) throws UserNotFoundException{
		// TODO Auto-generated method stub
		if(!userRepo.existsById(userId)){
			
			throw new UserNotFoundException("Invalid UserID");
		}
		return userRepo.findByUserIdAndPassword(userId, password);
	}

}
