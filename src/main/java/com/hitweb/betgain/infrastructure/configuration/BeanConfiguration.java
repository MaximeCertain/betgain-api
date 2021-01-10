package com.hitweb.betgain.infrastructure.configuration;

import com.hitweb.betgain.domain.user.repository.UserRepository;
import com.hitweb.betgain.domain.user.service.DomainUserService;
import com.hitweb.betgain.domain.user.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class BeanConfiguration {
        @Bean
        UserService userService(UserRepository userRepository) {
            return new DomainUserService(userRepository);
        }
}
