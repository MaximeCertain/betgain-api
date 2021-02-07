package com.hitweb.betgain.domain.moneyflow.usecases.payload.response;

import com.hitweb.betgain.domain.core.Response;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;

import java.util.ArrayList;
import java.util.List;

public class ListMoneyFlowsResponse extends Response {
    private List<MoneyFlow> moneyFlows;

    public List<MoneyFlow> getMoneyFlows() {
        return moneyFlows;
    }

    public void setMoneyFlows(List<MoneyFlow> moneyFlows) {
        this.moneyFlows = moneyFlows;
    }
}
