package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.infrastructure.postgres.entities.CommunityBetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaCommunityBetRepository extends JpaRepository<CommunityBetEntity, Long> {

}
