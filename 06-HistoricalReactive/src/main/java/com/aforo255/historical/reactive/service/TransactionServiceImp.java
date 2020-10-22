package com.aforo255.historical.reactive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aforo255.historical.reactive.document.Transaction;
import com.aforo255.historical.reactive.repositroy.ITransactionRepository;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class TransactionServiceImp implements ITransactionService{

	@Autowired
	private ITransactionRepository repository;
	
	@Override
	public Flux<Transaction> findAll() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Mono<Transaction> findById(String Id) {
		// TODO Auto-generated method stub
		return repository.findById(Id);
	}

}
