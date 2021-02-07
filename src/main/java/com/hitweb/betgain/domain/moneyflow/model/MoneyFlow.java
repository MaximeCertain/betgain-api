package com.hitweb.betgain.domain.moneyflow.model;

import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;

import java.util.Date;

public class MoneyFlow {
    private long id;
    private float amount;
    private Date date;
    private MoneyFlowState moneyFlowState;
    private Client client;

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

    public MoneyFlowState getMoneyFlowState() {
        return moneyFlowState;
    }

    public void setMoneyFlowState(MoneyFlowState moneyFlowState) {
        this.moneyFlowState = moneyFlowState;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
