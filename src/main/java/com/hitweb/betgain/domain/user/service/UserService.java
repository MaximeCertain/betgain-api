package com.hitweb.betgain.domain.user.service;


import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.usecases.payload.request.ProfileRequest;
import com.hitweb.betgain.domain.user.usecases.payload.request.UserRequest;
import com.hitweb.betgain.domain.user.usecases.payload.request.ValidateAccountRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.ClientResponse;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;

public interface UserService {

    public UserResponse saveUser(UserRequest user);
    public UserResponse editUser(UserRequest user);
    public Iterable<User> findAll();
    public UserResponse validateAccount(ValidateAccountRequest validateAccountRequest, int id);
    public ClientResponse editProfile(ProfileRequest profileRequest);

}
