package com.capg.ewallet.service;

import java.util.List;

import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.UserAlreadyExistsException;
import com.capg.ewallet.errors.UserNotFoundException;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;

public interface UserService {

	public WalletUser createWalletUser(WalletUser walletUser) throws UserAlreadyExistsException;

	public List<WalletUser> getAllWalletUser();

	public WalletAccount getOneAccount(int accountId) throws AccountNotFoundException;

	public WalletUser getUser(int userId, String password) throws UserNotFoundException;

	public void deleteWalletUser(int userId);
	
	

}
