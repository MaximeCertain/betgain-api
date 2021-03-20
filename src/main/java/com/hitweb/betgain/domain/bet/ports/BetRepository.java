package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.user.model.User;

import java.util.List;

public interface BetRepository {
    Bet save(Bet bet);
    List<Bet> getBetsHistoric(long id);
    public List<Bet> getBetsSinceOdd(long id);

}
