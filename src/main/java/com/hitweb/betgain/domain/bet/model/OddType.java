package com.hitweb.betgain.domain.bet.model;

public class OddType {
    private long id;
    private EOddType code;
    private String label;

    public OddType(long id, EOddType code, String label) {
        this.id = id;
        this.code = code;
        this.label = label;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public EOddType getCode() {
        return code;
    }

    public void setCode(EOddType code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
