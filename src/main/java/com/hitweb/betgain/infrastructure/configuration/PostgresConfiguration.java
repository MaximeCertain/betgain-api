package com.hitweb.betgain.infrastructure.configuration;

import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackages = {"com.hitweb.betgain.infrastructure.postgres.repository"})
public class PostgresConfiguration {

}
