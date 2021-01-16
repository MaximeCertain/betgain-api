package com.hitweb.betgain.domain.user.ports;

public interface PasswordEncoderInterface {
    public String encodePassword(String plainPassword);
}
