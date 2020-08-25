package com.capg.ewallet.controller;

import java.util.List;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import com.capg.ewallet.model.WalletAdmin;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.model.adminCredentials;
import com.capg.ewallet.service.UserService;


@RestController

@RequestMapping("/users")
public class UserController {
	
	@Autowired 
	UserService userService;
	
//	@Autowired
//	
//	adminService service;
	
	@PostMapping("/public/createaccount")
	public WalletUser createWalletUser(@RequestBody WalletUser walletUser) throws UserAlreadyExistsException {
		return userService.createWalletUser(walletUser);
		
	}
//	@PostMapping("/public/admin/createadmin")
//	public WalletAdmin createWalletAdmin(@RequestBody WalletAdmin walletAdmin)  {
//		return service.createWalletAdmin(walletAdmin);
//		
//	}
//	
	
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
	
//	@PostMapping("/public/authenticate")
//	public adminCredentials getAdmin(@RequestBody adminCredentials credentials)
//	{
//		WalletAdmin admin= service.getAdmin(credentials.getAdminId(), credentials.getPassword());
//		
//		return new adminCredentials(admin.getAdminId(), admin.getPassword());
//		
//	}
}
