package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.bet.model.Odd;
import com.hitweb.betgain.infrastructure.postgres.entities.MatchEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.MoneyFlowStateEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.OddTypeEntity;

public class OddAdapter {

    public static OddEntity adapt(Odd odd) {
        OddEntity oddEntity = new OddEntity();
        oddEntity.setId(odd.getId());
        oddEntity.setValue(odd.getValue());

        if (odd.getOddType() != null) {
            OddTypeEntity oddTypeEntity = OddTypeAdapter.adapt(odd.getOddType());
            oddEntity.setOddType(oddTypeEntity);
        }

        if (odd.getMatch() != null) {
            MatchEntity matchEntity = MatchAdapter.adapt(odd.getMatch());
            oddEntity.setMatchEntity(matchEntity);
        }

        return oddEntity;
    }

    public static Odd reverse(OddEntity oddEntity) {

        Odd odd = new Odd(OddTypeAdapter.reverse(oddEntity.getOddType()), oddEntity.getValue(), oddEntity.getId());

        return odd;
    }
}
