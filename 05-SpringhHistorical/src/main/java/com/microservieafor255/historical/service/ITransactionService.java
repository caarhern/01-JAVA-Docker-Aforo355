package com.microservieafor255.historical.service;

import com.microservieafor255.historical.entity.Transaction;

public interface ITransactionService {

	public Transaction save (Transaction transaction);
	public Iterable<Transaction> findByAccountId (Integer accountId);
	public Iterable <Transaction> findAll();
}


