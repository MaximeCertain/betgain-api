package com.hitweb.betgain.domain.bet.service.payload.request;

import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;

public class BetRequest {
    private long userId;
    private Odd odd;
    private float amount;
    private User loggedClient;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public Odd getOdd() {
        return odd;
    }

    public void setOdd(Odd odd) {
        this.odd = odd;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getLoggedClient() {
        return loggedClient;
    }

    public void setLoggedClient(User loggedClient) {
        this.loggedClient = loggedClient;
    }
}
