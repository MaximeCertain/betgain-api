package com.hitweb.betgain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class BetgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetgainApplication.class, args);
	}

}
