package com.hitweb.betgain.domain.moneyflow.service;

import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.ListMoneyFlowsRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.request.MoneyFlowRequest;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.ListMoneyFlowsResponse;
import com.hitweb.betgain.domain.moneyflow.usecases.payload.response.MoneyFlowResponse;

public interface MoneyFlowService {
    public MoneyFlowResponse makeMoneyFlow(MoneyFlowRequest moneyFlowRequest);
    public ListMoneyFlowsResponse listMoneyFlows(ListMoneyFlowsRequest listMoneyFlowsRequest);
}
