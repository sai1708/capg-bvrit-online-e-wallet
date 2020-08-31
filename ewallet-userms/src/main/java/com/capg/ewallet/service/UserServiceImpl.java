
package com.capg.ewallet.service;

import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.tomcat.jni.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.UserAlreadyExistsException;
import com.capg.ewallet.errors.UserNotFoundException;
import com.capg.ewallet.exception.UserNameInvalidException;
import com.capg.ewallet.exception.UserNumberInvalidException;
import com.capg.ewallet.exception.UserPasswordInvalidException;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletUser;
import com.capg.ewallet.repo.AccountMsRepo;
import com.capg.ewallet.repo.UserRepo;


@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	UserRepo userRepo;
	
	@Autowired
	AccountMsRepo accountMsRepo;

	@Override
	public WalletUser createWalletUser(WalletUser walletUser) throws UserAlreadyExistsException {
		// TODO Auto-generated method stub
		
//		Pattern p1=Pattern.compile("[A-Z]{1}[a-zA-Z0-9]{6,14}$");
//		Matcher m1=p1.matcher(walletUser.getUserName());
//		Pattern p2=Pattern.compile("^(?=.*[0-9])"+ "(?=.*[a-z])(?=.*[A-Z])"+ "(?=.*[@#$%^&+=])"+ "(?=\\S+$).{8,20}$");
//		Matcher m2=p2.matcher(walletUser.getPassword());
//		Pattern p3=Pattern.compile("\\d{10}");
//		Matcher m3=p3.matcher(walletUser.getPhoneNumber().toString());
//		if(!(m1.find() &&  m1.group().equals(walletUser.getUserName())))
//		{
//			throw new UserNameInvalidException("Username should start with capital letter ad size should be 2-14  characters");
//			
//		}
//		else if(!( m2.find() &&  m2.group().equals(walletUser.getPassword())) )
//		{
//   			throw new UserPasswordInvalidException("User password must contain "
//   					+ "capital letter,small letters and special character "
//   					+ "without starting with number and range should be between 8 and 20");
//		}
//		
//		else if(!( m3.find() &&  m3.group().equals(walletUser.getPhoneNumber().toString())) )
//		{
//			throw new UserNumberInvalidException("contact number should contain 10 digits");
//		}
//	
		 if(userRepo.existsById(walletUser.getUserId())) {
			throw new UserAlreadyExistsException("user already exists");
		}
		else
		return userRepo.save(walletUser);
	}

	@Override
	public List<WalletUser> getAllWalletUser() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public WalletAccount getOneAccount(int accountId) throws AccountNotFoundException{
		// TODO Auto-generated method stub
		if(!accountMsRepo.existsById(accountId)) {
			throw new AccountNotFoundException("account does not exist");
		}
		return accountMsRepo.getOne(accountId);
	}

	@Override
	public WalletUser getUser(int userId, String password) throws UserNotFoundException{
		// TODO Auto-generated method stub
		if(!userRepo.existsById(userId)){
			
			throw new UserNotFoundException("Invalid UserID");
		}
		return userRepo.findByUserIdAndPassword(userId, password);
	}

	@Override
	public void deleteWalletUser(int userId) {
		// TODO Auto-generated method stub
	    userRepo.deleteById(userId);
	}

	@Override
	public int findByUserId(int userId) {
		// TODO Auto-generated method stub
		WalletUser user= userRepo.findByUserId(userId);
		WalletAccount account=user.getWalletAccount();
		return account.getAccountId();	

	}

}
