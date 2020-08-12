package com.capg.movie.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capg.movie.model.WalletUser;

public interface AccountMsRepo extends JpaRepository<WalletUser, Integer> {

}
