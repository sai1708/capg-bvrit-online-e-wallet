//package com.capg.ewallet.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.capg.ewallet.model.WalletAdmin;
//import com.capg.ewallet.model.WalletUser;
//import com.capg.ewallet.repo.adminRepo;
//
//public class AdminServiceImpl implements adminService{
//	
//	@Autowired
//	adminRepo repo;
//
//	@Override
//	public WalletAdmin getAdmin(int adminId, String password) {
//		// TODO Auto-generated method stub
//		return repo.findByAdminIdAndPassword(adminId, password);
//	}
//
//	@Override
//	public WalletAdmin createWalletAdmin(WalletAdmin walletAdmin) {
//		// TODO Auto-generated method stub
//		return repo.save(walletAdmin);
//	}
//
//}
