package com.capg.ewallet.ms.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity

public class WalletUser {
	
	@Id
	private int userId;
	private String userName;
	private String password;
	private String phoneNumber;
	private String loginName;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName=userName;
	}
	
	public WalletUser() {
		super();
	
		// TODO Auto-generated constructor stub
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
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public WalletUser(int userId, String userName, String password, String phoneNumber, String loginName) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginName = loginName;
	}
	@Override
	public String toString() {
		return " WalletUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", loginName=" + loginName + "]";
	}
}
	
	
	