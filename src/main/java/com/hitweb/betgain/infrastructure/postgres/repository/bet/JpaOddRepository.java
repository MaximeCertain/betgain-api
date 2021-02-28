package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.infrastructure.postgres.entities.BetStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface JpaOddRepository extends JpaRepository<OddEntity, Long> {

    @Query("select odd from OddEntity odd where odd.oddType.id = ?1 and odd.matchEntity.id = ?2 and odd.date = " +
            "(SELECT max (odd.date) from OddEntity odd where odd.oddType.id = ?1 and odd.matchEntity.id = ?2)")
    <Optional> OddEntity findSinceOddType(Long typeId, Long matchId);

}
