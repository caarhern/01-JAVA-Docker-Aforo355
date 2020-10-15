package com.microservieafor255.historical.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservieafor255.historical.entity.Transaction;

@Service
public class TransactionEvents {

	@Autowired
	private ITransactionService service ; 
	@Autowired
	ObjectMapper objectMapper ;
	
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);
	
	public void processTransactionEvent (ConsumerRecord<Integer, String> consumerdRecord) throws JsonMappingException, JsonProcessingException {
		
		Transaction event = objectMapper.readValue(consumerdRecord.value(), Transaction.class);
		log.info("transactionEvent : {}",event.getAccountId());
		service.save(event);
	}
	
	
}
