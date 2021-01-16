package com.hitweb.betgain.domain.user.usecases.payload.request;

import com.hitweb.betgain.domain.user.model.User;

public class UserRequest extends User {
    private String toto;

    public String getToto() {
        return toto;
    }

    public void setToto(String toto) {
        this.toto = toto;
    }
}
