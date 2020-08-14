package com.capg.ewallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class TransferData {
    @Id
	private int transactionId;
	private String description;
	private int fromAccountId;
	private int toAccountId;
	private double amount;
	private Status status;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(int fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public int getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(int toAccountId) {
		this.toAccountId = toAccountId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public Status getStatus() {
		return status;
	}
	public void setStatus(Status status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "TransferData [transactionId=" + transactionId + ", description=" + description + ", fromAccountId="
				+ fromAccountId + ", toAccountId=" + toAccountId + ", amount=" + amount + ", status=" + status + "]";
	}
	public TransferData(int transactionId, String description, int fromAccountId, int toAccountId, double amount,
			Status status) {
		super();
		this.transactionId = transactionId;
		this.description = description;
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.status = status;
	}
	public TransferData() {
		// TODO Auto-generated constructor stub
	}
}
