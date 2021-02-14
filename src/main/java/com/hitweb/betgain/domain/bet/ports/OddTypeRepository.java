package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.bet.model.EOddType;

public interface OddTypeRepository {
    public OddType findBetTypeState(EOddType code);

}
