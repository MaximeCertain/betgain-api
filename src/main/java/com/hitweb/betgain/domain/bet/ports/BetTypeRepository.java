package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.bet.model.EOddType;

public interface BetTypeRepository {
    public OddType findBetTypeState(EOddType code);

}
