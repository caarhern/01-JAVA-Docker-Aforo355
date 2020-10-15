package com.microservieafor255.historical.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.microservieafor255.historical.entity.Transaction;
import com.microservieafor255.historical.repository.ITransactionRepository;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	ITransactionRepository repository;

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return repository.save(transaction);
	}

	@Override
	public Iterable<Transaction> findByAccountId(Integer accountId) {
		// TODO Auto-generated method stub
		return repository.findByAccountId(accountId);
	}

	@Override
	public Iterable<Transaction> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

}
