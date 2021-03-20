package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaOpponentRepository extends JpaRepository<OpponentEntity, Long> {

    @Query("select opponent from OpponentEntity opponent JOIN MatchEntity match on (match.awayTeam.id = opponent.id or match.homeTeam.id = opponent.id)" +
            " WHERE match.id = ?1 AND opponent.team.code = ?2")
    <Optional> OpponentEntity findSinceOddType(Long matchId, String codeTeam);
}