package com.microservieafor255.deposit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservieafor255.deposit.dao.TransactionDao;
import com.microservieafor255.deposit.domain.Transaction;
@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionDao trasanctionDao;
	
	@Override
	@Transactional(readOnly = true)
	public Transaction findById(Integer id) {
		// TODO Auto-generated method stub
		return trasanctionDao.findById(id).orElse(null);
	}

	@Override
	public Transaction save(Transaction transaction) {
		// TODO Auto-generated method stub
		return trasanctionDao.save(transaction);
	}

}

