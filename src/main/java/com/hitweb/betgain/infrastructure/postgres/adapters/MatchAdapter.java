package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.infrastructure.postgres.entities.CompetitionEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;

public class MatchAdapter {
    public static MatchEntity adapt(Match match) {
        MatchEntity matchEntity = new MatchEntity();

        matchEntity.setDate(match.getDate());
        matchEntity.setId(match.getId());

        if(match.getAwayTeam() != null){
            OpponentEntity opponentEntity = OpponentAdapter.adapt(match.getAwayTeam());
            matchEntity.setAwayTeam(opponentEntity);
        }

        if(match.getHomeTeam() != null){
            OpponentEntity opponentHOmeEntity = OpponentAdapter.adapt(match.getHomeTeam());
            matchEntity.setHomeTeam(opponentHOmeEntity);
        }

        if(match.getCompetition() != null){
            CompetitionEntity competitionEntity = CompetitionAdapter.adapt(match.getCompetition());
            matchEntity.setCompetition(competitionEntity);
        }

        return matchEntity;
    }

    public static Match reverse(MatchEntity matchEntity) {

        Match match = new Match(matchEntity.getId(), matchEntity.getDate(), null, null, matchEntity.getCode());

        return match;
    }
}