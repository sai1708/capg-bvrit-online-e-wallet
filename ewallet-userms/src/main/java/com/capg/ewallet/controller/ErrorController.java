package com.capg.ewallet.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.UserAlreadyExistsException;
import com.capg.ewallet.errors.UserNotFoundException;
import com.capg.ewallet.model.ErrorResponse;

@RestControllerAdvice
public class ErrorController {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {AccountNotFoundException.class})
	public ErrorResponse handleAccountNotFoundException(Exception ex,HttpServletRequest req) {
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), req.getRequestURI());
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {UserNotFoundException.class})
	public ErrorResponse handleUserNotFoundException(Exception ex,HttpServletRequest req) {
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), req.getRequestURI());
	}
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(value = {UserAlreadyExistsException.class})
	public ErrorResponse handleUserAlreadyExistsException(Exception ex,HttpServletRequest req) {
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase(), HttpStatus.NOT_FOUND.value(), req.getRequestURI());
	}
	

}
