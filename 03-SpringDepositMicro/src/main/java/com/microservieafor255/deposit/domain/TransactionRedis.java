package com.microservieafor255.deposit.domain;

import java.io.Serializable;

import javax.persistence.Column;

public class TransactionRedis implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private String id;
	
	private double amount;
	private String type;
	private String creationDate;
	private Integer accountId;
	
	public TransactionRedis() {
	}
	
	public TransactionRedis(double amount, String type, String creationDate, Integer accountId) {
		this.amount = amount;
		this.type = type;
		this.creationDate = creationDate;
		this.accountId = accountId;
	}

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Integer getAccountId() {
		return accountId;
	}
	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	
}
