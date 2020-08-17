package com.capg.ewallet.service;

import java.util.List;

import com.capg.ewallet.exception.AccountNotFoundException;
import com.capg.ewallet.exception.InvalidAmountException;
import com.capg.ewallet.model.TransferData;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;

public interface TransactionMsInterface {

	public WalletAccount transferAmount(WalletTransaction walletTransaction) throws AccountNotFoundException,InvalidAmountException;
	public WalletAccount getAllWalletAccount();
	public WalletTransactionList getAllWalletTransaction();

	//public WalletAccount transferAmount(TransferData transferdata);
}
