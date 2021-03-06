package com.hitweb.betgain.domain.bet.service.payload.request;

import com.hitweb.betgain.domain.user.model.User;

public class ListBetRequest {
    private long userId;
    private User loggedUser;

    public ListBetRequest(long userId, User loggedUser) {
        this.userId = userId;
        this.loggedUser = loggedUser;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }
}