package com.hitweb.betgain.domain.user.usecases;

import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.PasswordEncoderInterface;
import com.hitweb.betgain.domain.user.usecases.payload.request.UserRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import org.springframework.beans.BeanUtils;


public class AddUserUseCase {

    private final UserRepository userRepository;
    private final PasswordEncoderInterface passwordEncoder;


    public AddUserUseCase(UserRepository userRepository, PasswordEncoderInterface passwordEncoderInterface) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoderInterface;
    }

    public UserResponse add(UserRequest userRequest) {

        User user = new User();
        BeanUtils.copyProperties(userRequest, user);

        UserResponse userResponse = new UserResponse();

        if (user.getEmail() == null || user.getFirstname() == null || user.getLastname() == null || user.getPassword() == null || user.getUsername() == null) {
            userResponse.setMessage("La création est impossible, données manquantes");
            return userResponse;
        }

        if (user.getRoles().size() == 0) {
            Role role = new Role();
            role.setName(ERole.ROLE_USER);
            role.setId(1);
            user.addRole(role);
        }

        user.setPassword(passwordEncoder.encodePassword(user.getPassword()));
        User newUser = userRepository.save(user);

        userResponse.setUser(newUser);
        userResponse.setMessage("Création de l'utilisateur " + newUser.getUsername() + " réussie");

        return userResponse;
    }
}
