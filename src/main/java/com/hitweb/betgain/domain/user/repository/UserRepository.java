package com.hitweb.betgain.domain.user.repository;

import com.hitweb.betgain.domain.user.model.User;

//https://reflectoring.io/spring-hexagonal/
public interface UserRepository {
    void save(User user);
    public Iterable<User> findAll();
}
