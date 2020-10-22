package com.aforo255.historical.reactive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.aforo255.historical.reactive.document.Transaction;
import com.aforo255.historical.reactive.service.ITransactionService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class HistoricalController {

	@Autowired
	private ITransactionService service;
    @GetMapping("/listar") 
	public Mono<ResponseEntity<Flux<Transaction>>> lista() {

		return Mono.just(
				ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll()));

	}
    
    @GetMapping("/transaction/{Id}")
    public Mono <ResponseEntity<Transaction>> ver (@PathVariable String Id ){
    	
    	return service.findById(Id).map(p->ResponseEntity.ok()
    			.contentType(MediaType.APPLICATION_JSON)
    			.body(p))
    			.defaultIfEmpty(ResponseEntity.notFound().build());    			
    			
    }      

}
