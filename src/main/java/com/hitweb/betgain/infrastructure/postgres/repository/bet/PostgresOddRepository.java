package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.infrastructure.postgres.adapters.MatchAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.OddAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import org.springframework.stereotype.Component;

@Component
public class PostgresOddRepository implements OddRepository {

    private final JpaOddRepository jpaOddRepository;

    public PostgresOddRepository(JpaOddRepository jpaOddRepository) {
        this.jpaOddRepository = jpaOddRepository;
    }


    public Odd getLastOddForOddTypeAndMatch(OddType oddType, Match match) {

        System.out.println(oddType.getId());
        OddEntity oddEntity = jpaOddRepository.findSinceOddType(oddType.getId(), match.getId());

        if (oddEntity == null) {
            return null;
        }
        System.out.println(oddEntity.getDate());

        return OddAdapter.reverse(oddEntity);
    }

    public Odd save(Odd odd) {
        OddEntity oddEntity = OddAdapter.adapt(odd);
        OddEntity oddEntitySaved = jpaOddRepository.save(oddEntity);
        return OddAdapter.reverse(oddEntitySaved);
    }

}
