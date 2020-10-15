package com.microservieafor255.historical.listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.microservieafor255.historical.service.TransactionEvents;
@Component
public class TransactionEventsConsumerListener {
    @Autowired
	TransactionEvents events ; 
    private Logger log = LoggerFactory.getLogger(TransactionEventsConsumerListener.class);
    
    @KafkaListener(topics = {"transaction-events"})
    public void onMessage (ConsumerRecord<Integer, String> consumerRecord) throws JsonMappingException, JsonProcessingException {
    	 log .info("********* MICRO SERVICE HISTORICAL ***********");
    	 log .info("ConsumerRecord : {} ", consumerRecord.value());
    	 events.processTransactionEvent(consumerRecord);
    	
    }
	
}
