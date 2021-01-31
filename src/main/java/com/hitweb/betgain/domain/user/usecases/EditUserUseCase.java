package com.hitweb.betgain.domain.user.usecases;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.PasswordEncoderInterface;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.usecases.payload.request.UserRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;
import org.springframework.beans.BeanUtils;

public class EditUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoderInterface passwordEncoder;

    public EditUserUseCase(UserRepository userRepository, PasswordEncoderInterface passwordEncoderInterface) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoderInterface;
    }

    public UserResponse edit(UserRequest userRequest) {

        User editedUserDomain = new User();
        BeanUtils.copyProperties(userRequest, editedUserDomain);

        User currentUser = userRepository.findUser(userRequest.getId());
        editedUserDomain.setPassword(currentUser.getPassword());

        UserResponse userResponse = new UserResponse();
        if (editedUserDomain.getEmail() == null || editedUserDomain.getFirstname() == null || editedUserDomain.getLastname() == null || editedUserDomain.getPassword() == null || editedUserDomain.getUsername() == null || new Long(editedUserDomain.getId())== null || editedUserDomain.getRoles().size() == 0) {
            userResponse.setMessage("La création est impossible, données manquantes");
            return userResponse;
        }

        User newUser = userRepository.save(editedUserDomain);
        userResponse.setUser(newUser);
        userResponse.setMessage("Edition de l'utilisateur " + newUser.getUsername() + " réussie");

        return userResponse;
    }
}