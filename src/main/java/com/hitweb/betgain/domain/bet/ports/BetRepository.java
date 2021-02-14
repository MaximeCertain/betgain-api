package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.user.model.User;

public interface BetRepository {
    Bet save(Bet bet);

}
