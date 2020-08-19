package com.capg.ewallet.errors;

public class UserNotFoundException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6270971342792467425L;
	
	
	public UserNotFoundException(String message) {
		super(message);
	}

}
