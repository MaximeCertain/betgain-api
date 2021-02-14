package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.bet.model.BetState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.infrastructure.postgres.entities.BetStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowEntity;

public class BetStateAdapter {
    public static BetStateEntity adapt(BetState betState) {
        BetStateEntity betStateEntity = new BetStateEntity();
        betStateEntity.setCode(betState.getCode());
        betStateEntity.setId(betState.getId());
        betStateEntity.setLabel(betState.getLabel());
        return betStateEntity;
    }

    public static BetState reverse(BetStateEntity betStateEntity) {
        BetState betState = new BetState();
        betState.setLabel(betStateEntity.getLabel());
        betState.setCode(betStateEntity.getCode());
        betState.setId(betStateEntity.getId());
        return betState;
    }
}
