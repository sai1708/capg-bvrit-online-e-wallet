package com.capg.ewallet.controller;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.ewallet.exception.AccountBalanceEmptyException;
import com.capg.ewallet.exception.ErrorInfo;

@RestControllerAdvice
public class ErrorController {
	@ResponseStatus(code=HttpStatus.BAD_GATEWAY)
	@ExceptionHandler(value= {AccountBalanceEmptyException.class})
	public ErrorInfo handleBalanceEmpty(AccountBalanceEmptyException ex , HttpServletRequest req)
	{
		return new ErrorInfo(LocalDateTime.now(), ex.getMessage(),req.getRequestURI().toString());
	}
}
