package com.microservieafor255.account.service;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservieafor255.account.entity.Account;
import com.microservieafor255.account.entity.Transaction;

@Service
public class TransactionEvents {
	@Autowired
	private IAccountService accountService;
	@Autowired
	ObjectMapper objectMapper;
	private Logger log = LoggerFactory.getLogger(TransactionEvents.class);

	public void processTransactionEvent(ConsumerRecord<Integer, String> consumerRecord)
			throws JsonMappingException, JsonProcessingException {

		double newAmount = 0;
		Account account = new Account();
		Transaction event = objectMapper.readValue(consumerRecord.value(), Transaction.class);
		log.info("accountId : {} ", event.getAccountId());
		account = accountService.findById(event.getAccountId());
		
		switch(event.getType()) {
		case "deposito":
			newAmount= account.getTotalAmount() + event.getAmount();
			break ;
			
		case "retiro" :
			newAmount= account.getTotalAmount() - event.getAmount();
		
		}
		account.setTotalAmount(newAmount);
		log.info("Actulizando N° cuenta "+ event.getAccountId());
		accountService.save(account);	

	}

}