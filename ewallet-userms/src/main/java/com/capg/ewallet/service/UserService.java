package com.capg.ewallet.service;

import java.util.List;

import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;

public interface UserService {

	public WalletUser createWalletUser(WalletUser walletUser);

	public List<WalletUser> getAllWalletUser();

	public WalletAccount getOneAccount(int accountId);
	
	

}
