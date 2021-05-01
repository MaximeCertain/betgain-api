package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.CommunityBet;

public interface CommunityBetRepository {
    CommunityBet save(CommunityBet communityBet);
}
