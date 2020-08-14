package com.capg.ewallet.service;

import java.util.List;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransactions;

public interface AccountMsService {
	
	public WalletAccount addWalletAccount(WalletAccount walletAccount) throws AccountAlreadyExistsException, InvalidAmountException;
	
	public WalletAccount addAmount(WalletAccount walletAccount) throws AccountNotFoundException, InvalidAmountException;
	
	//public WalletAccount fundtransfer(double amount, int fromAccountId, int toAccountId);

	public WalletAccount fundtransfer(WalletTransactions walletTransactions);

	public List<WalletTransactions> getAllWalletTransactions();
	

	
}
