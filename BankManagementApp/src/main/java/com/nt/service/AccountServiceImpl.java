package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.AccountNotFoundException;
import com.nt.model.Account;
import com.nt.repository.IAccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {

	@Autowired 
	private IAccountRepository repo;
	@Override
	public Account createAccount(Account account) {
		
		return repo.save(account);
	}

	@Override

public Account getAccountDetailsByAccountNumber(Long accountNumber) {
		
		Optional<Account> account=repo.findById(accountNumber);
	if(account.isEmpty()) {
		throw new AccountNotFoundException("Account not found with number: " + accountNumber);
	}
	
	Account found=account.get();
	return found;
	
	/*
	//using java 8 features
	return repo.findById(accountNumber)
	       .orElseThrow(() -> new AccountNotFoundException("Account not found with number: " + accountNumber));*/
	}
	@Override
	public List<Account> getAllAccountDetails() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}

	@Override
	public Account depositAmount(Long accountNumber, Double amount) {
		
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new AccountNotFoundException("Account not found with number: " + accountNumber);
		}
		
		Account accountPresent=account.get();
		
		Double TotalBalance=accountPresent.getAccount_balance()+amount;
		accountPresent.setAccount_balance(TotalBalance);
		repo.save(accountPresent);
		
		
		return accountPresent;
	}

	@Override
	public Account withdrawAmount(Long accountNumber, Double amount) {
		Optional<Account> account=repo.findById(accountNumber);
		if(account.isEmpty()) {
			throw new AccountNotFoundException("Account not found with number: " + accountNumber);
		}
		
		Account accountPresent=account.get();
	Double TotalBalance=	accountPresent.getAccount_balance()-amount;
		accountPresent.setAccount_balance(TotalBalance);
		repo.save(accountPresent);
		
		return accountPresent;
	}

	@Override
	public void closeAccount(Long accountNumber) {
		
		if(!repo.existsById(accountNumber)) {
			throw new AccountNotFoundException("Account not found with number: " + accountNumber);
		}
		repo.deleteById(accountNumber);
		
		
	}

}
