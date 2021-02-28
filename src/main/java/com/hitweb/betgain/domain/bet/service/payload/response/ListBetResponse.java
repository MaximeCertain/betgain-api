package com.hitweb.betgain.domain.bet.service.payload.response;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.core.Response;

import java.util.List;

public class ListBetResponse extends Response {
    private List<Bet> bets;
    private EBetResponseCode responseCode;


    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }

    public EBetResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(EBetResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
