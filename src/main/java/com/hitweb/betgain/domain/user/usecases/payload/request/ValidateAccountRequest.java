package com.hitweb.betgain.domain.user.usecases.payload.request;

public class ValidateAccountRequest {
    public String confirmationCode;

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }
}
