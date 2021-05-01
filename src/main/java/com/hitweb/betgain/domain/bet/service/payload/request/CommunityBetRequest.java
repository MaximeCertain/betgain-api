package com.hitweb.betgain.domain.bet.service.payload.request;

public class CommunityBetRequest extends BetRequest {
    private float treshold;

    public float getTreshold() {
        return treshold;
    }

    public void setTreshold(float treshold) {
        this.treshold = treshold;
    }
}
