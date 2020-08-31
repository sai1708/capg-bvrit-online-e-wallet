package com.capg.ewallet.service;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.model.WalletUser;

public interface AccountMsService {
	
	public WalletAccount addWalletAccount(WalletAccount walletAccount) throws AccountAlreadyExistsException, InvalidAmountException;
	
	public WalletAccount addAmount(@RequestBody WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException;
	
	public List<WalletAccount> getAllWalletAccount() throws AccountNotFoundException;

	public WalletAccount getOneWalletAccount(int accountId) throws AccountNotFoundException;
	
	public WalletTransactionList getAllWalletTransaction();

	public List<WalletTransaction> getOneWalletTransaction(int accountId);

	

	
}
