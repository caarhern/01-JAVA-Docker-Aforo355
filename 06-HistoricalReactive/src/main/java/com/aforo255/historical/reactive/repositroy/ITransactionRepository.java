package com.aforo255.historical.reactive.repositroy;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.aforo255.historical.reactive.document.Transaction;

public interface ITransactionRepository extends ReactiveMongoRepository<Transaction, String> {

}
