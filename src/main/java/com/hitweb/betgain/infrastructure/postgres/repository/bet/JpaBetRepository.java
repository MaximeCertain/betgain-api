package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.infrastructure.postgres.entities.BetEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaBetRepository extends JpaRepository<BetEntity, Long> {
}
