package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresBetRepository implements BetRepository {
    @Override
    public Bet save(Bet bet) {
        return bet;
    }
}
