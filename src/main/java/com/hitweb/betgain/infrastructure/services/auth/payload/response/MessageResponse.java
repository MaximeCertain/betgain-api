package com.hitweb.betgain.infrastructure.services.auth.payload.response;

public class MessageResponse {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public MessageResponse(String message) {
        this.message = message;
    }
}
