package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.domain.bet.ports.OddRepository;
import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.infrastructure.postgres.adapters.BetAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.MatchAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.OddAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Odd> findByMatchId(Match match) {
        //MatchEntity matchEntity = MatchAdapter.adapt(match);
        System.out.println(match.getCode());
    //    List<OddEntity> odds = jpaOddRepository.findByMatchEntity_Id(match.getId());
        List<Odd> odds = jpaOddRepository.findByMatchEntity_Id(match.getId()).stream().map(oddEntity -> OddAdapter.reverse(oddEntity)).collect(Collectors.toList());
        return odds;
    }

}
