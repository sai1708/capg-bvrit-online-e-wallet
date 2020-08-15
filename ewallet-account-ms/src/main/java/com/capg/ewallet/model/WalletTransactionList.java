package com.capg.ewallet.model;

import java.util.List;

public class WalletTransactionList {
	private List<WalletTransaction> walletTransaction;

	public WalletTransactionList() {
		super();
		// TODO Auto-generated constructor stub
	}

	public WalletTransactionList(List<WalletTransaction> walletTransaction) {
		super();
		this.walletTransaction = walletTransaction;
	}

	public List<WalletTransaction> getWalletTransaction() {
		return walletTransaction;
	}

	public void setWalletTransaction(List<WalletTransaction> walletTransaction) {
		this.walletTransaction = walletTransaction;
	}
}
