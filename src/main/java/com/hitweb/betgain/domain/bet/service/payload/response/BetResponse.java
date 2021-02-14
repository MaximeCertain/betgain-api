package com.hitweb.betgain.domain.bet.service.payload.response;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import com.hitweb.betgain.domain.core.Response;
import com.hitweb.betgain.domain.user.ports.UserRepository;

public class BetResponse extends Response {
    private Bet bet;
    private EBetResponseCode responseCode;

    public Bet getBet() {
        return bet;
    }

    public void setBet(Bet bet) {
        this.bet = bet;
    }

    public EBetResponseCode getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(EBetResponseCode responseCode) {
        this.responseCode = responseCode;
    }
}
