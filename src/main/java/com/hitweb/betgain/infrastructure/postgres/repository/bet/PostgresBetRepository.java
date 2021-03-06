package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.ports.BetRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.BetAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.BetEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PostgresBetRepository implements BetRepository {

    private final JpaBetRepository jpaBetRepository;

    public PostgresBetRepository(JpaBetRepository jpaBetRepository) {
        this.jpaBetRepository = jpaBetRepository;
    }

    @Override
    public Bet save(Bet bet) {
        BetEntity betEntity = BetAdapter.adapt(bet);

        Bet betSaved = BetAdapter.reverse(jpaBetRepository.save(betEntity));

        return betSaved;
    }

    @Override
    public List<Bet> getBetsHistoric(long id) {
        return null;
    }
}
