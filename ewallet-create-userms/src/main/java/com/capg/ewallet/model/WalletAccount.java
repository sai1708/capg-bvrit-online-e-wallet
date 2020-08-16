package com.capg.ewallet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class WalletAccount {
	
	@Id
	private int accountId;
	private double accountBalance;
	private Status status;
	@ElementCollection
	private List<Integer>tHistory;

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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	

	public List<Integer> gettHistory() {
		return tHistory;
	}

	public void settHistory(List<Integer> tHistory) {
		this.tHistory = tHistory;
	}
	
	

	@Override
	public String toString() {
		return "WalletAccount [accountId=" + accountId + ", accountBalance=" + accountBalance + ", status=" + status
				+ ", tHistory=" + tHistory + "]";
	}

	public WalletAccount(int accountId, double accountBalance, Status status, List<Integer> tHistory) {
		super();
		this.accountId = accountId;
		this.accountBalance = accountBalance;
		this.status = status;
		this.tHistory = tHistory;
	}

	public WalletAccount() {
		// TODO Auto-generated constructor stub
	}

}
