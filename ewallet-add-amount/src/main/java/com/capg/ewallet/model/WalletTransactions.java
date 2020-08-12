package com.capg.ewallet.model;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


public class WalletTransactions {
	
	
	private int TransactionId;
	private String Description;
	@DateTimeFormat(pattern="yyyy/mm/ddThh:mm:ss")
	private LocalDateTime dateOfTransaction;
	private double Amount;
	private double AccountBalance;
	public int getTransactionId() {
		return TransactionId;
	}
	public void setTransactionId(int transactionId) {
		TransactionId = transactionId;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getAmount() {
		return Amount;
	}
	public void setAmount(double amount) {
		Amount = amount;
	}
	public double getAccountBalance() {
		return AccountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		AccountBalance = accountBalance;
	}
	public WalletTransactions(int transactionId, String description, LocalDateTime dateOfTransaction, double amount,
			double accountBalance) {
		super();
		TransactionId = transactionId;
		Description = description;
		this.dateOfTransaction = dateOfTransaction;
		Amount = amount;
		AccountBalance = accountBalance;
	}
	
	
	public WalletTransactions() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalletTransactions [TransactionId=" + TransactionId + ", Description=" + Description
				+ ", dateOfTransaction=" + dateOfTransaction + ", Amount=" + Amount + ", AccountBalance="
				+ AccountBalance + "]";
	}
	
	

}
