package com.capg.ewallet.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;



@Entity
public class WalletAccount {
	
	@Id
	private int accountId;
	private double accountBalance;
	private Status status;
	
	@OneToMany
	//@Column(columnDefinition="tHistory")
	private List<WalletTransaction>tHistory;

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

	public List<WalletTransaction> gettHistory() {
		return tHistory;
	}

	public void settHistory(List<WalletTransaction> tHistory) {
		this.tHistory = tHistory;
	}

	@Override
	public String toString() {
		return "WalletAccount [accountId=" + accountId + ", accountBalance=" + accountBalance + ", status=" + status
				+ ", tHistory=" + tHistory + "]";
	}

	public WalletAccount(int accountId, double accountBalance, Status status, List<WalletTransaction> tHistory) {
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
