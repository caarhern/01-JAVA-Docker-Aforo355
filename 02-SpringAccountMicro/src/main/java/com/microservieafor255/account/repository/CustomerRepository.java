package com.microservieafor255.account.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.microservieafor255.account.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}