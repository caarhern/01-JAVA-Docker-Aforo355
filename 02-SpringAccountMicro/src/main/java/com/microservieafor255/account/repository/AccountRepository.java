package com.microservieafor255.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservieafor255.account.entity.Account;

@Repository
public interface AccountRepository  extends CrudRepository<Account, Integer>{
	
	Account findByIdCustomer(Integer id_customer);
	
	Account findByIdCustomerOrIdAccount(Integer id_customer, Integer id_account);

}