package com.microservieafor255.deposit.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.microservieafor255.deposit.dao.ITransactionRedis;
import com.microservieafor255.deposit.dao.TransactionDao;
import com.microservieafor255.deposit.domain.Transaction;
import com.microservieafor255.deposit.domain.TransactionRedis;
@Service
public class TransactionServiceImpl implements ITransactionService {

	@Autowired
	private TransactionDao trasanctionDao;
	@Autowired
	private ITransactionRedis transactionRedis ;
	
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

	@Override
	public  TransactionRedis findByIdRedis (String id ) {
		return transactionRedis.findById(id);
	}
	@Override
	public void save (TransactionRedis transaction) {
		transactionRedis.save(transaction);
	}
	@Override
	public Map<String, TransactionRedis> findAll(){
		return transactionRedis.findAll();
	}

}

