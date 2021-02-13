package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.BetState;
import com.hitweb.betgain.domain.bet.model.EBetState;

public interface BetStateRepository {
    public BetState findBetStateState(EBetState code);
}
