package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.match.model.EOpponent;
import com.hitweb.betgain.domain.match.model.Opponent;
import com.hitweb.betgain.domain.match.model.Team;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;

public class OpponentAdapter {
    public static OpponentEntity adapt(Opponent opponent) {

        OpponentEntity opponentEntity = new OpponentEntity();
        opponentEntity.setId(opponent.getId());
        opponentEntity.setGoalsNumber(opponent.getGoalsNumber());
        opponentEntity.setRedCardNumber(opponent.getRedCardNumber());
        opponentEntity.setType(opponent.getType().toString());

        if (opponent.getTeam() != null) {
            TeamEntity teamEntity = TeamAdapter.adapt(opponent.getTeam());
            opponentEntity.setTeam(teamEntity);
        }
        return opponentEntity;
    }

    public static Opponent reverse(OpponentEntity opponentEntity) {

        Opponent opponent = new Opponent(EOpponent.valueOf(opponentEntity.getType()), opponentEntity.getId(), opponentEntity.getTeam().getName(),
                opponentEntity.getTeam().getLogoPath()
                , opponentEntity.getTeam().getCode(), opponentEntity.getGoalsNumber(), opponentEntity.getYellowCardNumber(),
                opponentEntity.getRedCardNumber());

        if (opponentEntity.getTeam() != null) {
            Team team = TeamAdapter.reverse(opponentEntity.getTeam());
            opponent.setTeam(team);
        }

        return opponent;
    }
}
