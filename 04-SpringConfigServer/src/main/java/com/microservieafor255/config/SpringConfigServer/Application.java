package com.microservieafor255.config.SpringConfigServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer //Le agregamos esta linea para poder autorizqar el uso de config server.
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
