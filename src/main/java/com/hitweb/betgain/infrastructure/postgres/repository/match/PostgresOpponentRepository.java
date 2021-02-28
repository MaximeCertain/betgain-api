package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.domain.match.model.Opponent;
import com.hitweb.betgain.domain.match.ports.OpponentRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.OpponentAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.TeamAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;
import org.springframework.stereotype.Component;

@Component
public class PostgresOpponentRepository implements OpponentRepository {
    private final JpaOpponentRepository jpaOpponentRepository;

    public PostgresOpponentRepository(JpaOpponentRepository jpaOpponentRepository) {
        this.jpaOpponentRepository = jpaOpponentRepository;
    }

    public Opponent save(Opponent opponent) {
        OpponentEntity opponentEntity = OpponentAdapter.adapt(opponent);
        OpponentEntity opponentEntity1 = jpaOpponentRepository.save(opponentEntity);
        return OpponentAdapter.reverse(opponentEntity1);

    }
}
