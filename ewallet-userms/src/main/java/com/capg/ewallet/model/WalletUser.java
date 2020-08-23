package com.capg.ewallet.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class WalletUser {
	
	@Id
	private int userId;
	private String userName;
	private String password;
	private String phoneNumber;
	private String loginName;
	@OneToOne(cascade={CascadeType.ALL})
	WalletAccount walletAccount;
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
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
	public WalletAccount getWalletAccount() {
		return walletAccount;
	}
	public void setWalletAccount(WalletAccount walletAccount) {
		this.walletAccount = walletAccount;
	}
	public WalletUser(int userId, String userName, String password, String phoneNumber, String loginName,
			WalletAccount walletAccount) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.loginName = loginName;
		this.walletAccount = walletAccount;
	}
	@Override
	public String toString() {
		return "WalletUser [userId=" + userId + ", userName=" + userName + ", password=" + password + ", phoneNumber="
				+ phoneNumber + ", loginName=" + loginName + ", walletAccount=" + walletAccount + "]";
	}
	
	public WalletUser() {
		// TODO Auto-generated constructor stub
	}
	
	
}
