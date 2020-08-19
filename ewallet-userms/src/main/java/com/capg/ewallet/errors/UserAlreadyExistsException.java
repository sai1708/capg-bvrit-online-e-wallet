package com.capg.ewallet.errors;

public class UserAlreadyExistsException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6270971342792467425L;
	
	
	public UserAlreadyExistsException(String message) {
		
	super(message);
	}

}
