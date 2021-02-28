package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.EOddType;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.bet.ports.OddTypeRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.MatchAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.OddTypeAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.OddTypeEntity;
import org.springframework.stereotype.Component;

@Component
public class PostgresOddTypeRepository implements OddTypeRepository {

    private final JpaOddTypeRepository jpaOddTypeRepository;

    public PostgresOddTypeRepository(JpaOddTypeRepository jpaOddTypeRepository) {
        this.jpaOddTypeRepository = jpaOddTypeRepository;
    }

    @Override
    public OddType findBetTypeState(EOddType code) {
        return null;
    }

    public OddType findOddType(String code) {
        OddTypeEntity oddTypeEntity = jpaOddTypeRepository.findByCode(code);

        if (oddTypeEntity == null) {
            return null;
        }

        return OddTypeAdapter.reverse(oddTypeEntity);

    }

}
