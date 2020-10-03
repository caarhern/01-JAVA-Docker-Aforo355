package com.aforo255.SpringBootMicroservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class MicroserviceAforo255SecurityApplication implements CommandLineRunner {

	@Autowired
	private BCryptPasswordEncoder passwordEncode;
	public static void main(String[] args) {
		SpringApplication.run(MicroserviceAforo255SecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		String password="12345";
		for (int i = 0 ; i<4;i++) {
			
			String passwordBcryt=passwordEncode.encode(password);
			System.out.println(passwordBcryt);
		}
	}

}