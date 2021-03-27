package com.hitweb.betgain.domain.bet.ports;

import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.match.model.Match;

import java.util.List;

public interface OddRepository {
    public Odd save(Odd odd);

    public List<Odd> findByMatchId(Match matchId);
}
