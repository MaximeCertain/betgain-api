package com.hitweb.betgain.infrastructure.postgres.repository.bet;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.CommunityBet;
import com.hitweb.betgain.domain.bet.ports.CommunityBetRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.BetAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.CommunityBetAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.BetEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.CommunityBetEntity;
import org.springframework.stereotype.Component;

@Component
public class PostgresCommunityBetRepository implements CommunityBetRepository {
    private final JpaCommunityBetRepository jpaCommunityBetRepository;


    public PostgresCommunityBetRepository(JpaCommunityBetRepository jpaCommunityBetRepository) {
        this.jpaCommunityBetRepository = jpaCommunityBetRepository;
    }

    @Override
    public CommunityBet save(CommunityBet communityBet) {

        CommunityBetEntity communityBetEntity = CommunityBetAdapter.adapt(communityBet);



        CommunityBet communityBetSaved = CommunityBetAdapter.reverse((CommunityBetEntity) jpaCommunityBetRepository.save(communityBetEntity));

        return communityBetSaved;
    }
}
