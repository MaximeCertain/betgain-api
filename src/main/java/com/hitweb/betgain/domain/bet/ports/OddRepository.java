package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.Odd;

public interface OddRepository {
    public Odd save(Odd odd);
}
