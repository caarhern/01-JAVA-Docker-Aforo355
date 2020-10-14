package com.microservieafor255.account.kafka.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microservieafor255.account.service.TransactionEvents;

@Component
public class TransactionEventsConsumer {
	
	/*
	 * Esta es la clase donde entra la transaccion.
	 * 
	 */
	
	private Logger log = LoggerFactory.getLogger(TransactionEventsConsumer.class);
	@Autowired
	private TransactionEvents transactionEvents;
	@KafkaListener(topics = {"transaction-events"})
	public void OnMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
		log.info("ComsumerRecord: {} ", consumerRecord.value());
		transactionEvents.processTransactionEvent(consumerRecord);
	}
}
