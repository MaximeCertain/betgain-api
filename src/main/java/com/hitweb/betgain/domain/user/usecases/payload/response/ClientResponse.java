package com.hitweb.betgain.domain.user.usecases.payload.response;

import com.hitweb.betgain.domain.core.Response;
import com.hitweb.betgain.domain.user.model.Client;

public class ClientResponse extends Response {
    private Client client;

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
