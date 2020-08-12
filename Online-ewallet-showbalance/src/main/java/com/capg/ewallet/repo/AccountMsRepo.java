package com.capg.ewallet.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.ewallet.model.WalletUser;


public interface AccountMsRepo extends JpaRepository<WalletUser, Integer> {

}
