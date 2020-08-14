package com.capg.ewallet.errors;

public class AccountAlreadyExistsException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6270971342792467425L;
	
	
	public AccountAlreadyExistsException(String message) {
		super(message);
	}

}
