package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;

public class MatchAdapter {
    public static MatchEntity adapt(Match match) {
        MatchEntity matchEntity = new MatchEntity();

        matchEntity.setDate(match.getDate());
        matchEntity.setId(match.getId());

        return matchEntity;
    }

    public static Match reverse(MatchEntity matchEntity) {

        Match match = new Match(matchEntity.getId(), matchEntity.getDate(), null, null);

        return match;
    }
}