package com.aforo255.historical.reactive.service;

import com.aforo255.historical.reactive.document.Transaction;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ITransactionService {

	public Flux<Transaction> findAll();
	public Mono<Transaction> findById(String Id);
	
}
