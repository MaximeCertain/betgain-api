package com.hitweb.betgain.domain.user.model;

import com.hitweb.betgain.domain.user.ports.UserInterface;

public class UserFactory {
    public UserInterface create(ERole eRole) {
        switch (eRole) {
            case ROLE_USER:
                return new Client();
            case ROLE_OPERATOR:
                return new com.hitweb.betgain.domain.user.model.User();
            case ROLE_ADMINISTRATOR:
                return new com.hitweb.betgain.domain.user.model.User();
            default:
                return new com.hitweb.betgain.domain.user.model.User();
        }
    }
}
