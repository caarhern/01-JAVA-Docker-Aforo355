package com.microservieafor255.deposit.service;

import com.microservieafor255.deposit.domain.Transaction;

public interface ITransactionService {
	
	public Transaction findById(Integer id);
	public Transaction save(Transaction transaction);

}
