package com.hitweb.betgain.domain.user.service;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.PasswordEncoderInterface;
import com.hitweb.betgain.domain.user.usecases.EditUserUseCase;
import com.hitweb.betgain.domain.user.usecases.payload.request.UserRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.usecases.AddUserUseCase;

public class DomainUserService implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoderInterface passwordEncoderInterface;


    public DomainUserService(UserRepository userRepository, PasswordEncoderInterface passwordEncoderInterface) {
        this.userRepository = userRepository;
        this.passwordEncoderInterface = passwordEncoderInterface;

    }

    @Override
    public UserResponse saveUser(UserRequest userRequest) {
      return new AddUserUseCase(userRepository, passwordEncoderInterface).add(userRequest);
    }

    @Override
    public UserResponse editUser(UserRequest userRequest) {
        return new EditUserUseCase(userRepository, passwordEncoderInterface).edit(userRequest);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepository.findAll();
    }


}
