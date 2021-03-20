package com.hitweb.betgain.domain.match.ports;

import com.hitweb.betgain.domain.match.model.Opponent;

public interface OpponentRepository {
    public Opponent getOpponent(long idMatch, String codeTeam);

    public Opponent save(Opponent opponent);
}
