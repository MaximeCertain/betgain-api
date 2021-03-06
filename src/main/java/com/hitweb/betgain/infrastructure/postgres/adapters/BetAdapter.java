package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.Bet;
import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlowState;
import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.*;
import com.hitweb.betgain.infrastructure.postgres.entities.BetEntity;

public class BetAdapter {
    public static BetEntity adapt(Bet bet) {
        BetEntity betEntity = new BetEntity();
        betEntity.setAmount(bet.getAmount());
        betEntity.setDate(bet.getDate());
        betEntity.setId(bet.getId());

        if (bet.getUser() != null) {
            UserEntity userEntity = UserAdapter.adapt(bet.getUser());
            betEntity.setUser(userEntity);
        }

        if (bet.getOdd() != null) {
            OddEntity oddEntity = OddAdapter.adapt(bet.getOdd());
            betEntity.setOdd(oddEntity);
        }

        return betEntity;
    }

    public static Bet reverse(BetEntity betEntity) {
        Bet bet = new Bet();
        bet.setAmount(betEntity.getAmount());
        bet.setDate(betEntity.getDate());
        bet.setId(betEntity.getId());

        if (betEntity.getUser() != null) {
            User user = UserAdapter.reverse(betEntity.getUser());
            bet.setUser((Client) user);
        }

        if (betEntity.getOdd() != null) {
            Odd odd = OddAdapter.reverse(betEntity.getOdd());
            bet.setOdd(odd);
        }

        return bet;
    }
}
