package com.microservieafor255.deposit.service;

import java.util.List;
import java.util.Map;

import com.microservieafor255.deposit.domain.Transaction;
import com.microservieafor255.deposit.domain.TransactionRedis;

public interface ITransactionService {
	
	public Transaction findById(Integer id);
	public List<Transaction> findByType(String type);
	public Transaction save(Transaction transaction);
	
	//Metodos para Redis.
	public TransactionRedis findByIdRedis(String id);
	public void save (TransactionRedis transaction);
	public Map<String, TransactionRedis> findAll();

}
