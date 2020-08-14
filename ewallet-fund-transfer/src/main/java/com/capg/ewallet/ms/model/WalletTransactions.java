package com.capg.ewallet.ms.model;



import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class WalletTransactions {
	
	@Id
	private int transactionId;
	private String description;
	@DateTimeFormat(pattern="yyyy/mm/ddThh:mm:ss")
	private LocalDateTime dateOfTransaction;
	private double amount;
	private double accountBalance;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		transactionId = transactionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		description = description;
	}
	public LocalDateTime getDateOfTransaction() {
		return dateOfTransaction;
	}
	public void setDateOfTransaction(LocalDateTime dateOfTransaction) {
		this.dateOfTransaction = dateOfTransaction;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		amount = amount;
	}
	public double getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(double accountBalance) {
		accountBalance = accountBalance;
	}
	public WalletTransactions(int transactionId, String description, LocalDateTime dateOfTransaction, double amount,
			double accountBalance) {
		super();
		transactionId = transactionId;
		description = description;
		this.dateOfTransaction = dateOfTransaction;
		amount = amount;
		accountBalance = accountBalance;
	}
	
	
	public WalletTransactions() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalletTransactions [TransactionId=" + transactionId + ", Description=" + description
				+ ", dateOfTransaction=" + dateOfTransaction + ", Amount=" + amount + ", AccountBalance="
				+ accountBalance + "]";
	}
	
	

}

