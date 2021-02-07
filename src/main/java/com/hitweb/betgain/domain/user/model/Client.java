package com.hitweb.betgain.domain.user.model;

import com.hitweb.betgain.domain.user.ports.UserInterface;

public class Client extends User implements UserInterface {
    private String cardNumber;
    private String expirationDate;
    private String visualCryptogram;
    private float capital;

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

    public float getCapital() {
        return capital;
    }

    public void setCapital(float capital) {
        this.capital = capital;
    }
}
