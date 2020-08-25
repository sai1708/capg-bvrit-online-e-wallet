package com.capg.ewallet.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class WalletAdmin {
	@Id
	private int adminId;
	private String adminName;
	private String password;
	private String phoneNumber;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getAdminName() {
		return adminName;
	}
	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public WalletAdmin(int adminId, String adminName, String password, String phoneNumber) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	
	public WalletAdmin() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "WalletAdmin [adminId=" + adminId + ", adminName=" + adminName + ", password=" + password
				+ ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
