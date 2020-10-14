package com.microservieafor255.account.service;

import java.util.List;

import com.microservieafor255.account.entity.Account;

public interface IAccountService {
	
	public List<Account> findAll();
	public Account findById (Integer id);
	public Account save(Account account);
	public Account findAccounByIdCustomer(Integer id);

}
