package com.aforo255.historical.reactive.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;

import com.aforo255.historical.reactive.document.Transaction;
import com.aforo255.historical.reactive.service.ITransactionService;

import reactor.core.publisher.Mono;

@Component
public class HistoricalHandler {

	@Autowired
	private ITransactionService service ;
	
	
	public Mono<ServerResponse> listar (ServerRequest request ){
		
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findAll(), Transaction.class);
	}
	
	public Mono<ServerResponse> ver (ServerRequest request){
		
		String id = request.pathVariable("id");
		return ServerResponse.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(service.findById(id),Transaction.class)
				.switchIfEmpty(ServerResponse.notFound().build());
		
	}
	
}
