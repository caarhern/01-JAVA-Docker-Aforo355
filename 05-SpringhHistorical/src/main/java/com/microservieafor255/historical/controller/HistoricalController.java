package com.microservieafor255.historical.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservieafor255.historical.entity.Transaction;
import com.microservieafor255.historical.service.ITransactionService;

@RestController
public class HistoricalController {

	@Autowired
	private ITransactionService transaction ; 
	
	@GetMapping("/listar")
	public List<Transaction> listar (){
		
		return (List<Transaction>) transaction.findAll();		
	}
	
	@GetMapping("/transaction/{accountId}")
	public ResponseEntity<?> obtenerByAccountId (@PathVariable Integer accountId){
		Iterable<Transaction> iTransaction = transaction.findByAccountId(accountId);
		return ResponseEntity.ok(iTransaction);		
	}
	
}
