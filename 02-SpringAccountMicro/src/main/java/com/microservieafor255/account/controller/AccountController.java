package com.microservieafor255.account.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.microservieafor255.account.entity.Account;
import com.microservieafor255.account.service.IAccountService;

@RestController
public class AccountController {
	@Autowired
	private IAccountService iAccountService;
	
	@GetMapping("/cuenta")
	public List<Account> listar(){
		return iAccountService.findAll();
	}
	
	@GetMapping("/cuenta/{id}")
	public Account getAccountById(@PathVariable Integer id) {
		return iAccountService.findById(id);
	}
	
	@GetMapping("/cuentabycustomer/{id}")
	public Account getAccountByIdCustomer(@PathVariable Integer id) {
		return iAccountService.findAccounByIdCustomer(id);
	}
}
