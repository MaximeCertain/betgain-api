package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.bet.model.EOddType;
import com.hitweb.betgain.domain.bet.model.OddType;
import com.hitweb.betgain.infrastructure.postgres.entities.OddTypeEntity;

public class OddTypeAdapter {
    public static OddTypeEntity adapt(OddType oddType) {
        OddTypeEntity oddTypeEntity = new OddTypeEntity();
        oddTypeEntity.setId(oddType.getId());
        oddTypeEntity.setCode(oddType.getCode().toString());
        oddTypeEntity.setLabel(oddType.getLabel());

        return oddTypeEntity;
    }

    public static OddType reverse(OddTypeEntity oddTypeEntity) {

        OddType oddType = new OddType(oddTypeEntity.getId(), EOddType.valueOf(oddTypeEntity.getCode()), oddTypeEntity.getLabel());

        return oddType;
    }
}
