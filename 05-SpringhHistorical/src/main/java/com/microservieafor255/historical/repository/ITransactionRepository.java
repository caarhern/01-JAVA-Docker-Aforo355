package com.microservieafor255.historical.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.microservieafor255.historical.entity.Transaction;

public interface ITransactionRepository extends MongoRepository<Transaction, String> {
	@Query("{'accountId':?0}")
	public Iterable<Transaction> findByAccountId(Integer accountId);

}
