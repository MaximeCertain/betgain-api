package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.match.model.EOpponent;
import com.hitweb.betgain.domain.match.model.Opponent;
import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;

public class OpponentAdapter {
    public static OpponentEntity adapt(Opponent opponent) {

        OpponentEntity opponentEntity = new OpponentEntity();
        opponentEntity.setId(opponent.getId());
        opponentEntity.setGoalsNumber(opponent.getGoalsNumber());
        opponentEntity.setRedCardNumber(opponent.getRedCardNumber());
        opponentEntity.setType(opponent.getType().toString());

        return opponentEntity;
    }

    public static Opponent reverse(OpponentEntity opponentEntity) {

        Opponent opponent = new Opponent(EOpponent.valueOf(opponentEntity.getType()), opponentEntity.getId(), opponentEntity.getTeam().getName(),
                opponentEntity.getTeam().getLogoPath()
                , opponentEntity.getTeam().getCode(), opponentEntity.getGoalsNumber(), opponentEntity.getYellowCardNumber(),
                opponentEntity.getRedCardNumber());

        return opponent;
    }
}
