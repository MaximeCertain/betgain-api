package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.infrastructure.postgres.entities.BetEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JpaBetRepository extends JpaRepository<BetEntity, Long> {
    List<BetEntity> findByUserId(long id);
    List<BetEntity> findByOddId(long id);

    /*@Query("select bet from BetEntity bet WHERE bet.odd.id = ?1")
    <Optional> OpponentEntity findBetsForOdd(Long matchId, String codeTeam);*/
}
