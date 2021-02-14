package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.BetState;
import com.hitweb.betgain.domain.bet.model.EBetState;
import com.hitweb.betgain.domain.bet.ports.BetStateRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.BetStateAdapter;
import org.springframework.stereotype.Component;

@Component
public class PostgresBetStateRepository implements BetStateRepository {

    private final JpaBetStateRepository jpaBetStateRepository;

    public PostgresBetStateRepository(JpaBetStateRepository jpaBetStateRepository) {
        this.jpaBetStateRepository = jpaBetStateRepository;
    }

    @Override
    public BetState findBetStateByCode(EBetState code) {
        return BetStateAdapter.reverse(jpaBetStateRepository.findByCode(code.toString()));
    }
}
