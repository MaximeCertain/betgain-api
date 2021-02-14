package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.EOddType;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresOddTypeRepository implements OddTypeRepository {
    @Override
    public OddType findBetTypeState(EOddType code) {
        return null;
    }
}
