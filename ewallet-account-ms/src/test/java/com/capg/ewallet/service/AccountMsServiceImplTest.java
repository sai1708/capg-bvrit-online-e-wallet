package com.capg.ewallet.service;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.assertj.core.util.Arrays;
import org.joda.time.LocalDate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.ewallet.errors.AccountAlreadyExistsException;
import com.capg.ewallet.errors.AccountNotFoundException;
import com.capg.ewallet.errors.InvalidAmountException;
import com.capg.ewallet.model.WalletAccount;
import com.capg.ewallet.model.WalletTransaction;
import com.capg.ewallet.model.WalletTransactionList;
import com.capg.ewallet.repo.AccountMsRepo;

@SpringBootTest
class AccountMsServiceImplTest {
	

	@Autowired
	private AccountMsRepo accountMsRepo;
	
	@Autowired
	AccountMsService accountMsService;
	
	WalletAccount wa;
	
	@BeforeEach
	public void init()
	{
		List<WalletTransaction> tests= new ArrayList();
		tests.add(new WalletTransaction(547835,"transfered",LocalDateTime.now(),1001015,1001013,500,2000));
		 wa=new WalletAccount(1001015,500.0,null,tests);
		
	}


	@Test
	void testAddAmount() throws AccountNotFoundException, InvalidAmountException {
		
//
//		List<WalletTransaction> tests= new ArrayList();
//		tests.add(new WalletTransaction(879933,"transfered",LocalDateTime.now(),200,205,500,2000));
//		WalletAccount account=new WalletAccount(200,500.0,null,tests);
//		
		WalletAccount addamount=accountMsService.addAmount(wa);
		
		assertEquals(1000,addamount.getAccountBalance());
		
	}
	@Test
	public void testInvalidamountException() {
		
		List<WalletTransaction> tests= new ArrayList();
		tests.add(new WalletTransaction(879933,"transfered",LocalDateTime.now(),1001015,1001013,500,2000));
		WalletAccount account=new WalletAccount(1001015,-500.0,null,tests);
		
		assertThrows(InvalidAmountException.class,()->{
			accountMsService.addAmount(account);
		}) ;
	}
	
	@Test
	public void testAccountNotFoundException() {
		
		List<WalletTransaction> tests= new ArrayList();
		tests.add(new WalletTransaction(547835,"transfered",LocalDateTime.now(),1001015,205,500,2500));
		WalletAccount account=new WalletAccount(20000,500.0,null,tests);
		
		assertThrows(AccountNotFoundException.class,()->{
			accountMsService.addAmount(account);
		}) ;
	}
	
	
	 
	}
	 

	

