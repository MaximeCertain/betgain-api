package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgresBetRepository implements BetRepository {
    @Override
    public Bet save(Bet bet) {
        return bet;
    }

    @Override
    public List<Bet> getBetsHistoric(long id) {
        return null;
    }
}
