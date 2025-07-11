package com.nt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Account;
import com.nt.service.AccountServiceImpl;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/account")
public class AccountController {
	
	@Autowired 
	private AccountServiceImpl service;

	
	@PostMapping("/create")
	public ResponseEntity<Account> createAccount(@Valid @RequestBody Account account){
		return new ResponseEntity<>(service.createAccount(account),HttpStatus.CREATED);
		
	}
	/*	  multiple ways to create handeler mehtod in rest apo
		@PostMapping
		public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		    return ResponseEntity.status(HttpStatus.CREATED).body(service.createAccount(account));
		}
		  @PostMapping
		    public ResponseEntity<Account> createAccount(@RequestBody Account account) {
		        Account createdAccount = service.createAccount(account);
		        return new ResponseEntity<>(createdAccount, HttpStatus.CREATED);
		    }*/
	@GetMapping("/details/{accountNumber}")
	public ResponseEntity<Account> getAccountDetails(@PathVariable("accountNumber") Long accountNumber) {
	    return new ResponseEntity<>(service.getAccountDetailsByAccountNumber(accountNumber), HttpStatus.OK);
	}
	
@GetMapping("/getAll")
public ResponseEntity<List<Account>> getAllAccountDetails(){
	return new  ResponseEntity<>(service.getAllAccountDetails(),HttpStatus.OK);
	
}
	
@PutMapping("/deposit/{accountNumber}/{amount}")
public ResponseEntity<Account> depositMoney(@PathVariable Long accountNumber,@PathVariable Double amount){
	return new ResponseEntity<>(service.depositAmount(accountNumber, amount),HttpStatus.OK);
}

@PutMapping("withdraw/{accountNumber}/{amount}")
public ResponseEntity<Account> withdrawMoney(@PathVariable Long accountNumber,@PathVariable Double amount){
	return new ResponseEntity<>(service.withdrawAmount(accountNumber, amount),HttpStatus.OK);
}
@DeleteMapping("/delete/{accountNumber}")
public ResponseEntity<String> deleteAccount(@PathVariable Long accountNumber) {
    service.closeAccount(accountNumber);
    return new ResponseEntity<>("Account deleted successfully", HttpStatus.OK);
}


}
