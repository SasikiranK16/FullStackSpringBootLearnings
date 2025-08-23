package com.example.demo.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dtos.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;

@RestController
public class AccountControllers {

	@Autowired
	private AccountService accountService;
	@PostMapping("/create/account")
	public ResponseEntity<AccountDTO>createAccounts(@RequestBody Account account){
		return new ResponseEntity<>(accountService.createAccount(account),HttpStatus.CREATED);
	}
	@GetMapping("/account/{id}")
	public ResponseEntity<Account>getAccountDetailsById(@PathVariable("id")long id){
		return new ResponseEntity<>(accountService.getAccountDetailsById(id),HttpStatus.OK);
	}
	@GetMapping("/account/{id}/{amount}")
	public ResponseEntity<AccountDTO>getDeposit(@PathVariable("id")long id,@PathVariable("amount")double amount){
		return new ResponseEntity<>(accountService.getDepositAmount(id,amount),HttpStatus.ACCEPTED);
	}
	@PutMapping("/account/{id}/withdraw")
	public ResponseEntity<AccountDTO>getwithDraw(@PathVariable("id")long id,@RequestBody Map<String, Double>req){
		return new ResponseEntity<AccountDTO>(accountService.getWithdrawAmount(id,req.get("amount")),HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>>getAllDetails(){
		return new ResponseEntity<List<Account>>(accountService.getAllAccountsDetails(),HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/accounts/{id}/delete")
	public ResponseEntity<String>deleteAccount(@PathVariable("id")long id){
		accountService.deleteAccount(id);
		return new ResponseEntity<String>("Successfully Account Deleted!!",HttpStatus.ACCEPTED);
	}
}
