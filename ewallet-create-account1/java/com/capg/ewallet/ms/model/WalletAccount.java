package com.capg.ewallet.ms.model;



import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;



public class WalletAccount {
	
	
	private int accountId;
	private double accountBalance;
	private enum Status{ };
	
	private List<Integer>transactionHistory;
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		accountBalance = accountBalance;
	}
	public List<Integer> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<Integer> transactionHistory) {
		transactionHistory = transactionHistory;
	}
	public WalletAccount(int accountId, double accountBalance, List<Integer> transactionHistory) {
		super();
		accountId = accountId;
		accountBalance = accountBalance;
		transactionHistory = transactionHistory;
	}
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalletAccount [AccountId=" + accountId + ", AccountBalance=" + accountBalance + ", TransactionHistory="
				+ transactionHistory + "]";
	}
	 
	

}


