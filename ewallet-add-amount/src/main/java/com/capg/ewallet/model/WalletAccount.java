package com.capg.ewallet.model;

import java.util.List;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class WalletAccount {
	
	@Id
	private int accountId;
	private double accountBalance;
	//private enum Status{ };
	@ElementCollection
	private List<Integer>transactionHistory;
	@Override
	public String toString() {
		return "WalletAccount [accountId=" + accountId + ", accountBalance=" + accountBalance + ", transactionHistory="
				+ transactionHistory + "]";
	}
	public WalletAccount(int accountId, double accountBalance, List<Integer> transactionHistory) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.transactionHistory = transactionHistory;
	}
	public int getAccountId() {
		return accountId;
	}
	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}
	public List<Integer> getTransactionHistory() {
		return transactionHistory;
	}
	public void setTransactionHistory(List<Integer> transactionHistory) {
		this.transactionHistory = transactionHistory;
	}
	
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}

}
