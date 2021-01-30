package com.hitweb.betgain.infrastructure.configuration;

import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.service.DomainUserService;
import com.hitweb.betgain.domain.user.service.UserService;
import com.hitweb.betgain.infrastructure.services.mail.EmailServiceImpl;
import com.hitweb.betgain.infrastructure.services.security.PasswordSecurityEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

    @Configuration
    public class BeanConfiguration {
        @Bean
        UserService userService(UserRepository userRepository, PasswordSecurityEncoder passwordEncoder, EmailServiceImpl emailService) {
            return new DomainUserService(userRepository, passwordEncoder, emailService);
        }
}
