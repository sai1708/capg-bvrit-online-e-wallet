package com.capg.ewallet.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.model.ErrorResponse;


@RestControllerAdvice
public class ErrorController {
	

	@ResponseStatus(code = HttpStatus.REQUEST_TIMEOUT)
	@ExceptionHandler(value = AccountNotFoundException.class)
	public ErrorResponse handleAccountNotFoundException(Exception ex,HttpServletRequest req) {
		return new ErrorResponse(new Date(), ex.getMessage(), HttpStatus.REQUEST_TIMEOUT.getReasonPhrase(), HttpStatus.REQUEST_TIMEOUT.value(), req.getRequestURI());
	}

}
