package com.hitweb.betgain.domain.user.usecases.payload.response;

import com.hitweb.betgain.domain.core.Response;
import com.hitweb.betgain.domain.user.model.User;

public class UserResponse extends Response {

    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
