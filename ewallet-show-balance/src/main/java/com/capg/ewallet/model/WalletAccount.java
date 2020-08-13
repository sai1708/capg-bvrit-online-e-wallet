package com.capg.ewallet.model;

import java.util.List;

import javax.persistence.ElementCollection;



public class WalletAccount {
	

	private int accountId;
	private double accountBalance;
	//private enum Status{ };
	@ElementCollection
	private List<Integer>tHistory;
	@Override
	public String toString() {
		return "WalletAccount [accountId=" + accountId + ", accountBalance=" + accountBalance + ", tHistory="
				+ tHistory + "]";
	}
	public WalletAccount(int accountId, double accountBalance, List<Integer> tHistory) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.tHistory = tHistory;
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
	public List<Integer> getTHistory() {
		return tHistory;
	}
	public void setTHistory(List<Integer> tHistory) {
		this.tHistory = tHistory;
	}
	
	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}

}