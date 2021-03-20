package com.hitweb.betgain.domain.match.ports;

import com.hitweb.betgain.domain.match.model.Match;

public interface MatchRepository {
    public Match getMatch(String code);
}
