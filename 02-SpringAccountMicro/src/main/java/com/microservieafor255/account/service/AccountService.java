package com.microservieafor255.account.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservieafor255.account.entity.Account;
import com.microservieafor255.account.repository.AccountRepository;

@Service
public class AccountService implements IAccountService{
	
	@Autowired
	AccountRepository accountRepository;

	@Override
	public List<Account> findAll() {
		// TODO Auto-generated method stub
		return (List<Account>) accountRepository.findAll();
	}

	@Override
	public Account findById(Integer id) {
		// TODO Auto-generated method stub
		return accountRepository.findById(id).orElse(null);
	}

	@Override
	public Account save(Account account) {
		// TODO Auto-generated method stub
		return accountRepository.save(account);
	}

	@Override
	public Account findAccounByIdCustomer(Integer id) {
		// TODO Auto-generated method stub
		return accountRepository.findByIdCustomer(id);
	}

}
