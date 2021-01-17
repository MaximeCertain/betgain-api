package com.hitweb.betgain.domain.user.ports;

import com.hitweb.betgain.domain.user.model.User;

//https://reflectoring.io/spring-hexagonal/
public interface UserRepository {
    User save(User user);
    public Iterable<User> findAll();
    public User findUser(long id);

}
