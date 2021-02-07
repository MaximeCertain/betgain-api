package com.hitweb.betgain.domain.moneyflow.usecases.payload.request;

import com.hitweb.betgain.domain.user.model.User;

public class ListMoneyFlowsRequest {
    private User loggedUser;
    private int userId;

    public ListMoneyFlowsRequest(User loggedUser, int userId) {
        this.loggedUser = loggedUser;
        this.userId = userId;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
