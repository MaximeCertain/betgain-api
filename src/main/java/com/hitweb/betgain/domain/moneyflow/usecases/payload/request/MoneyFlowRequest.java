package com.hitweb.betgain.domain.moneyflow.usecases.payload.request;

import com.hitweb.betgain.domain.user.model.User;

public class MoneyFlowRequest {
    private long userId;
    public float amount;
    private User loggedUser;

    private String cardNumber;
    private String expirationDate;
    private String visualCryptogram;
    private boolean saveBankDetails = false;

    public boolean isSaveBankDetails() {
        return saveBankDetails;
    }

    public void setSaveBankDetails(boolean saveBankDetails) {
        this.saveBankDetails = saveBankDetails;
    }


    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public User getLoggedUser() {
        return loggedUser;
    }

    public void setLoggedUser(User loggedUser) {
        this.loggedUser = loggedUser;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(String expirationDate) {
        this.expirationDate = expirationDate;
    }

    public String getVisualCryptogram() {
        return visualCryptogram;
    }

    public void setVisualCryptogram(String visualCryptogram) {
        this.visualCryptogram = visualCryptogram;
    }
}
