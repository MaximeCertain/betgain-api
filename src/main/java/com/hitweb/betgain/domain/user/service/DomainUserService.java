package com.hitweb.betgain.domain.user.service;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.repository.UserRepository;

public class DomainUserService implements UserService {

    private final UserRepository userRepository;


    public DomainUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public void saveUser(com.hitweb.betgain.domain.user.model.User user) {
        //régles métiers => validation ...
        userRepository.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }
}
