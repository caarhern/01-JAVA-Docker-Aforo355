package com.microservieafor255.deposit.dao;

import org.springframework.data.repository.CrudRepository;

import com.microservieafor255.deposit.domain.Transaction;

public interface TransactionDao extends CrudRepository<Transaction, Integer>{

}
