package com.microservieafor255.deposit.producer;

import java.util.ArrayList;
import java.util.List;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservieafor255.deposit.domain.Transaction;
import com.microservieafor255.deposit.domain.TransactionRedis;
import com.microservieafor255.deposit.service.ITransactionService;

@Component
public class DepositEventProducer {

	String topic = "transaction-events";
	private Logger log = LoggerFactory.getLogger(DepositEventProducer.class);
	@Autowired
	KafkaTemplate<Integer, String> kafkaTemplate;
	@Autowired
	ObjectMapper objectMapper;
	@Autowired
	private ITransactionService service ;
	
	
	public ListenableFuture<SendResult<Integer, String>> sendDepositEvent(Transaction depositEvent ) throws JsonProcessingException{
		Integer key = depositEvent.getId();
		String value = objectMapper.writeValueAsString(depositEvent);
		
		ProducerRecord<Integer, String> producerRecord=buildProducerRecord(key,value,topic);
		ListenableFuture<SendResult<Integer, String>> listenableFuture=kafkaTemplate.send(producerRecord);
		listenableFuture.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>() {

			@Override
			public void onSuccess(SendResult<Integer, String> result) {
				
				try {
					handleSuccess(key,value, result);
				} catch (JsonProcessingException e) {
					e.printStackTrace();
				}
			}

			@Override
			public void onFailure(Throwable ex) {
				handleFailure(key, value , ex);
				
			}
		});
		
		return listenableFuture ;
	}
	
	

	private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
		List<Header> recordHeaders = new ArrayList<>();
		recordHeaders.add(new RecordHeader("deposit-event-source", "scanner".getBytes()));
		return new ProducerRecord<>(topic, null, key, value, recordHeaders);
	}
	
	
	private void handleFailure (Integer key , String value , Throwable ex) {
		log.error("Error Sending the Message and the Execption is {}",ex.getMessage());
		try {
			throw ex ;
		}catch(Throwable throwable) {
			log.error("Error in OnFailure : {}",throwable.getMessage());
		}
	}
	
	private void handleSuccess (Integer key , String value , SendResult<Integer, String> result) throws JsonMappingException, JsonProcessingException {
		
		TransactionRedis trxRedis= objectMapper.readValue(value, TransactionRedis.class);
		service.save(trxRedis);	
		
		log.info("Message Sent Successfully for the key: {} and the value is {} , partition is {} " ,
				key,value , result.getRecordMetadata().partition());
	}

}
