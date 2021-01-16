package com.hitweb.betgain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = {"com.hitweb.betgain.infrastructure.postgres"})
public class BetgainApplication {

	public static void main(String[] args) {
		SpringApplication.run(BetgainApplication.class, args);
	}

}
