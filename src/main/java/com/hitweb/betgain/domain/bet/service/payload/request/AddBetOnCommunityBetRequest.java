package com.hitweb.betgain.domain.bet.service.payload.request;

public class AddBetOnCommunityBetRequest extends BetRequest {
    private long communityBetId;

    public long getCommunityBetId() {
        return communityBetId;
    }

    public void setCommunityBetId(long communityBetId) {
        this.communityBetId = communityBetId;
    }
}
