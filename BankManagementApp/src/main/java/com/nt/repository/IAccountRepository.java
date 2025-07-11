package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.model.Account;

public interface IAccountRepository extends JpaRepository<Account, Long> {

}
