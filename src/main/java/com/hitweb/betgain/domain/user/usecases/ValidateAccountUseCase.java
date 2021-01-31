package com.hitweb.betgain.domain.user.usecases;

import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.domain.user.usecases.payload.request.ValidateAccountRequest;
import com.hitweb.betgain.domain.user.usecases.payload.response.UserResponse;

public class ValidateAccountUseCase {

    private final UserRepository userRepository;

    public ValidateAccountUseCase(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public UserResponse validate(ValidateAccountRequest validateAccountRequest, int id) {

        User user = this.userRepository.findUser(id);
        UserResponse userResponse = new UserResponse();

        if(user.hasRole(ERole.ROLE_OPERATOR) || user.hasRole(ERole.ROLE_ADMINISTRATOR)){
            userResponse.setMessage("ce compte amaury n'a pas à être validé, ce n'ets pas un joueur");
            return userResponse;
        }

        if (user.getConfirmationCode().equals(validateAccountRequest.getConfirmationCode())) {
            userResponse.setMessage("l'utilisateur a bien été validé, il peut désormais faire des retraits");
            user.setValidated(true);
            user = this.userRepository.save(user);
        } else {
            userResponse.setMessage("l'utilisateur ne peut être validé, le code de confirmation est incorrect");
        }

        userResponse.setUser(user);

        return userResponse;

    }
}
