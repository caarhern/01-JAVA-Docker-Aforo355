package com.microservieafor255.deposit.dao;

import java.util.Map;

import com.microservieafor255.deposit.domain.TransactionRedis;


public interface ITransactionRedis {

	 void save (TransactionRedis transaction);
	 Map<String, TransactionRedis> findAll();
	 TransactionRedis findById(String id );
	 void update (TransactionRedis transaction);
	 void delete (String id );
}
