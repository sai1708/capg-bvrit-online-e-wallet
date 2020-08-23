package com.capg.ewallet.controller;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.UserAlreadyExistsException;
import com.capg.ewallet.errors.UserNotFoundException;
import com.capg.ewallet.model.UserCredentials;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	UserService userService;
	
	
	
	@PostMapping("/public/createaccount")
	public WalletUser createWalletUser(@RequestBody WalletUser walletUser) throws UserAlreadyExistsException {
		return userService.createWalletUser(walletUser);
		
	}
	
	@DeleteMapping("/public/deleteaccount/id/{id}")
	public void deleteWalletUser(@PathVariable ("id") int userId) {
		 userService.deleteWalletUser(userId);
	}
	
	@GetMapping("/public/getalluser")
	public List<WalletUser> getAllWalletUser(){
		return userService.getAllWalletUser();	
	}
	
	@GetMapping("/public/getaccount/id/{id}")
	public WalletAccount getOneAccount(@PathVariable ("id") int accountId) throws AccountNotFoundException {
		return userService.getOneAccount(accountId);
		
	}

	@PostMapping("/public/authenticate")
	public UserCredentials getUser(@RequestBody UserCredentials credentials) throws UserNotFoundException
	{
		WalletUser user= userService.getUser(credentials.getUserId(), credentials.getPassword());
		
		return new UserCredentials(user.getUserId(), user.getPassword());
		
	}
}
