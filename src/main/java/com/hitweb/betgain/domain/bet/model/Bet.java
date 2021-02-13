package com.hitweb.betgain.domain.bet.model;

import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;

import java.util.Date;

public class Bet {
    private long id;
    private float amount;
    private Date date;
    private BetState betState;
    private Odd odd;
    private Client user;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public BetState getBetState() {
        return betState;
    }

    public void setBetState(BetState betState) {
        this.betState = betState;
    }

    public Odd getOdd() {
        return odd;
    }

    public void setOdd(Odd odd) {
        this.odd = odd;
    }

    public Client getUser() {
        return user;
    }

    public void setUser(Client user) {
        this.user = user;
    }
}
