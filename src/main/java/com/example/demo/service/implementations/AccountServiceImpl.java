package com.example.demo.service.implementations;

import java.util.List;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.automappers.AutoUserMapper;
import com.example.demo.dtos.AccountDTO;
import com.example.demo.entity.Account;
import com.example.demo.repo.AccountRepo;
import com.example.demo.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private ModelMapper modelMapper;
	@Override
	public AccountDTO createAccount(Account account) {
		// TODO Auto-generated method stub
		Account act = AutoUserMapper.MAPPERS.mapToEntity(modelMapper.map(account, AccountDTO.class));
		Account savedAccount = accountRepo.save(act);
		AccountDTO accountDTO = AutoUserMapper.MAPPERS.mapToDTO(savedAccount);
		return accountDTO;
	}
	@Override
	public Account getAccountDetailsById(Long id) {
		// TODO Auto-generated method stub
		return accountRepo.findById(id).get();
	}
	@Override
	public AccountDTO getDepositAmount(Long id, double amount) {
		// TODO Auto-generated method stub
		Account accounts = accountRepo.findById(id).get();
		double blnc = accounts.getBalance()+amount;
		accounts.setBalance(blnc);
		accountRepo.save(accounts);
		return modelMapper.map(accounts, AccountDTO.class);
	}
	@Override
	public AccountDTO getWithdrawAmount(Long id, double amount) {
		// TODO Auto-generated method stub
		Account blncs = accountRepo.findById(id).get();
		double withdraws = blncs.getBalance()-amount;
		blncs.setBalance(withdraws);
		accountRepo.save(blncs);
		return AutoUserMapper.MAPPERS.mapToDTO(blncs);
	}
	@Override
	public List<Account> getAllAccountsDetails() {
		// TODO Auto-generated method stub
		return accountRepo.findAll();
	}
	@Override
	public void deleteAccount(long id) {
		// TODO Auto-generated method stub
		accountRepo.deleteById(id);
	}


	



}
