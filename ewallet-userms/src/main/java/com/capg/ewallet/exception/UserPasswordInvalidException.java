package com.capg.ewallet.exception;

public class UserPasswordInvalidException extends RuntimeException {
	public UserPasswordInvalidException(String message)
	{
		super(message);
	}
}
