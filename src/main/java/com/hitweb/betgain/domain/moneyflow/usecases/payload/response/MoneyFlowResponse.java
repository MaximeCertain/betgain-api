package com.hitweb.betgain.domain.moneyflow.usecases.payload.response;

import com.hitweb.betgain.domain.core.Response;
import com.hitweb.betgain.domain.moneyflow.model.EMoneyFlowState;
import com.hitweb.betgain.domain.moneyflow.model.MoneyFlow;
import com.hitweb.betgain.domain.user.model.Client;

public class MoneyFlowResponse extends Response {

    private Client client;
    private MoneyFlow moneyFlow;
    private EMoneyFlowResponseCode  codeResponse = EMoneyFlowResponseCode.MONEYFLOW_SUCCESS;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public MoneyFlow getMoneyFlow() {
        return moneyFlow;
    }

    public void setMoneyFlow(MoneyFlow moneyFlow) {
        this.moneyFlow = moneyFlow;
    }

    public EMoneyFlowResponseCode getCodeResponse() {
        return codeResponse;
    }

    public void setCodeResponse(EMoneyFlowResponseCode codeResponse) {
        this.codeResponse = codeResponse;
    }
}
