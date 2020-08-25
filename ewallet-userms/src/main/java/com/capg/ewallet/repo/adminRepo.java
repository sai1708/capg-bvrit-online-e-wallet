package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.WalletAdmin;


public interface adminRepo extends JpaRepository<WalletAdmin, Integer> {
	
	public WalletAdmin findByAdminIdAndPassword(int adminId,String password);

}
