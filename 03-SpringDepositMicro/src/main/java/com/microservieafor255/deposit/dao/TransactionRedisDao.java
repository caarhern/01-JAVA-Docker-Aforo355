package com.microservieafor255.deposit.dao;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.microservieafor255.deposit.domain.TransactionRedis;


@Repository
public class TransactionRedisDao  implements ITransactionRedis{
    @Autowired
	private RedisTemplate<String,TransactionRedis> redisTemplate;
    private HashOperations hashOperations ;
    String key ="TRANSACTION";
    @PostConstruct
    private void init () {
    	hashOperations=redisTemplate.opsForHash();
    }
	
	@Override
	public void save(TransactionRedis transaction) {
		hashOperations.put(key, transaction.getId(), transaction);
	}

	@Override
	public Map<String, TransactionRedis> findAll() {
		return hashOperations.entries(key);
	}

	@Override
	public TransactionRedis findById(String id) {
		return (TransactionRedis) hashOperations.get(key, id);
	}

	@Override
	public void update(TransactionRedis transaction) {
		save(transaction);
	}

	@Override
	public void delete(String id) {
		hashOperations.delete(key, id);
	}

}
