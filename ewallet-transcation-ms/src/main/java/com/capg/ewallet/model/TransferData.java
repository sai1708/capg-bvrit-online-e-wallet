package com.capg.ewallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;


public class TransferData {
  
	private int fromAccountId;
	private int toAccountId;
	private double amount;
	private Status status;
	
	@Override
	public String toString() {
		return "TransferData [fromAccountId=" + fromAccountId + ", toAccountId=" + toAccountId + ", amount=" + amount
				+ ", status=" + status + "]";
	}
	public TransferData(int fromAccountId, int toAccountId, double amount, Status status) {
		super();
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
		this.status = status;
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
	
	public TransferData() {
		// TODO Auto-generated constructor stub
	}
}
