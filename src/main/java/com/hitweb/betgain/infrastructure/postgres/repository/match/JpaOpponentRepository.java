package com.hitweb.betgain.infrastructure.postgres.repository.match;

import com.hitweb.betgain.infrastructure.postgres.entities.OpponentEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.TeamEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaOpponentRepository extends JpaRepository<OpponentEntity, Long> {

}
