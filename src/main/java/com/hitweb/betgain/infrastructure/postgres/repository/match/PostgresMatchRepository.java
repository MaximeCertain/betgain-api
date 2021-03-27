package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.domain.match.ports.MatchRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.MatchAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.repository.moneyflow.JpaMoneyFlowStateRepository;
import org.springframework.stereotype.Component;

@Component
public class PostgresMatchRepository implements MatchRepository {

    private final JpaMatchRepository jpaMatchRepository;

    public PostgresMatchRepository(JpaMatchRepository jpaMatchRepository) {
        this.jpaMatchRepository = jpaMatchRepository;
    }

    public Match getMatch(String code) {
        MatchEntity matchEntity = jpaMatchRepository.findByCode(code);
        System.out.println(matchEntity.getOdds().size());

        if (matchEntity == null) {
            return null;
        }

        return MatchAdapter.reverse(matchEntity);
    }

    public Match save(Match match) {
        MatchEntity matchEntity = MatchAdapter.adapt(match);
        MatchEntity matchEntitySaved = jpaMatchRepository.save(matchEntity);
        return MatchAdapter.reverse(matchEntitySaved);
    }

}