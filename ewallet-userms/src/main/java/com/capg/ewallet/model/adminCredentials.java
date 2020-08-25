package com.capg.ewallet.model;

public class adminCredentials {
	private int adminId;
	private String password;
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public adminCredentials() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "adminCredentials [adminId=" + adminId + ", password=" + password + "]";
	}
	public adminCredentials(int adminId, String password) {
		super();
		this.adminId = adminId;
		this.password = password;
	}
	

}
