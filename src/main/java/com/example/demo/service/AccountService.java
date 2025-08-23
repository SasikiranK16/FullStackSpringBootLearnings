package com.example.demo.service;

import java.util.List;

import com.example.demo.dtos.AccountDTO;
import com.example.demo.entity.Account;

public interface AccountService {

	AccountDTO createAccount(Account account);
	Account getAccountDetailsById(Long id);
	AccountDTO getDepositAmount(Long id,double amount);
	AccountDTO getWithdrawAmount(Long id, double amount);
	List<Account>getAllAccountsDetails();
	void deleteAccount(long id);
}
