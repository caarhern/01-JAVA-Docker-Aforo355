package com.microservieafor255.deposit.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.microservieafor255.deposit.domain.Transaction;
import com.microservieafor255.deposit.producer.DepositEventProducer;
import com.microservieafor255.deposit.service.ITransactionService;

@RestController
public class DepositEventController {

	private Logger log = LoggerFactory.getLogger(DepositEventController.class);
	@Autowired
	DepositEventProducer depositEventProducer;
	@Autowired
	private ITransactionService transactionService ;
	
	@PostMapping("/v1/depositevent")
	public ResponseEntity<Transaction> postDepositEvent (@RequestBody Transaction transactionEvent){
		log.info ("antes de tranSql");
		Transaction transql= transactionService.save(transactionEvent);
		log.info ("despues de tranSql");
		log.info ("antes de sendDepositEvent");
		try {
			depositEventProducer.sendDepositEvent(transql);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		log.info ("despues de sendDepositEvent");
		return ResponseEntity.status(HttpStatus.CREATED).body(transql) ;
	}
}
