package com.microservieafor255.deposit;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisClientConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.microservieafor255.deposit.domain.TransactionRedis;

@SpringBootApplication
public class MicroserviceAforo255DepositApplication {
	
//	Estos valores los traermos del properties es para 
    @Value("${spring.redis.host}")  
	private String REDIS_HOSTNAME;
    @Value("${spring.redis.port}")
    private int REDIS_PORT;
    
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
    	RedisStandaloneConfiguration configuration = new RedisStandaloneConfiguration(REDIS_HOSTNAME,REDIS_PORT);
    	JedisClientConfiguration  jedisClientConfiguration = JedisClientConfiguration
    			.builder().usePooling().build();
    	
    	JedisConnectionFactory factory = new JedisConnectionFactory(configuration, jedisClientConfiguration);
    	factory.afterPropertiesSet();
    	return factory ;
    	
    }
    
    @Bean
    RedisTemplate<String, TransactionRedis> redisTemplate(){
    	
    	RedisTemplate <String,TransactionRedis> redisTemplate = new RedisTemplate<>();
    	redisTemplate.setKeySerializer(new StringRedisSerializer());
    	redisTemplate.setHashKeySerializer(new GenericToStringSerializer<Object>(Object.class));
    	redisTemplate.setHashValueSerializer(new JdkSerializationRedisSerializer());
    	redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer() );
    	redisTemplate.setConnectionFactory(jedisConnectionFactory());
    	return redisTemplate;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAforo255DepositApplication.class, args);
	}

}
