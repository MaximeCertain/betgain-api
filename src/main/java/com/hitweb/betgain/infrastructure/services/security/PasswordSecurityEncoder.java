package com.hitweb.betgain.infrastructure.services.security;

import com.hitweb.betgain.domain.user.ports.PasswordEncoderInterface;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordSecurityEncoder extends BCryptPasswordEncoder implements PasswordEncoderInterface {

    public String encodePassword(String plainPassword) {
        return this.encode(plainPassword);
    }

}
