package com.capg.ewallet.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class WalletAccount {
	
	@Id
	private int AccountId;
	private double AccountBalance;
	private enum Status{ };
	@ElementCollection
	private List<Integer>TransactionHistory;
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		AccountBalance = accountBalance;
	}
	public List<Integer> getTransactionHistory() {
		return TransactionHistory;
	}
	public void setTransactionHistory(List<Integer> transactionHistory) {
		TransactionHistory = transactionHistory;
	}
	public WalletAccount(int accountId, double accountBalance, List<Integer> transactionHistory) {
		super();
		AccountId = accountId;
		AccountBalance = accountBalance;
		TransactionHistory = transactionHistory;
	}
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalletAccount [AccountId=" + AccountId + ", AccountBalance=" + AccountBalance + ", TransactionHistory="
				+ TransactionHistory + "]";
	}
	 
	

}
