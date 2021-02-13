package com.hitweb.betgain.domain.match.model;

public class Team {
    private long id;
    private String name;
    private String logo;
    private String code;

    public Team(long id, String name, String logo, String code) {
        this.id = id;
        this.name = name;
        this.logo = logo;
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
