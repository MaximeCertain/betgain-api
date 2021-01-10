package com.hitweb.betgain.domain.user.service;


import com.hitweb.betgain.domain.user.model.User;

public interface UserService {
    public void saveUser(User user);
    public Iterable<User> findAll();
}
