package com.hitweb.betgain.domain.user.usecases.payload.request;

import com.hitweb.betgain.domain.user.model.Client;

public class ProfileRequest extends Client {
    private boolean saveBankDetails = false;

    public boolean isSaveBankDetails() {
        return saveBankDetails;
    }

    public void setSaveBankDetails(boolean saveBankDetails) {
        this.saveBankDetails = saveBankDetails;
    }
}
