package com.microservieafor255.deposit.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.microservieafor255.deposit.domain.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Integer>{
	
	List<Transaction> findByType(String type);

}
