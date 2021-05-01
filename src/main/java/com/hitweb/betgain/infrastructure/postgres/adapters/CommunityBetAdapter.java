package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.bet.model.CommunityBet;
import com.hitweb.betgain.domain.bet.model.BetState;
import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.*;

public class CommunityBetAdapter {
    public static CommunityBetEntity adapt(CommunityBet communityBet) {
        CommunityBetEntity betEntity = new CommunityBetEntity();
        betEntity.setId(communityBet.getId());
        betEntity.setTreshold(communityBet.getThreshold());

        return betEntity;
    }

    public static CommunityBet reverse(CommunityBetEntity betEntity) {

        return new CommunityBet(betEntity.getId(),betEntity.getTreshold() );
    }

}
