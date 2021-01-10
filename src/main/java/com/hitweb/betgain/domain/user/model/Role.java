package com.hitweb.betgain.domain.user.model;

public class Role {

    private long id;
    private ERole name;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }
}
