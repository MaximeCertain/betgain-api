package com.hitweb.betgain.domain.match.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Competition {
    private long id;
    private String name;
    private Date startDate;
    private String code;
    private Date endDate;
    private List<Match> matchs;

    public Competition(long id, String name, Date startDate, Date endDate, String code) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.code = code;
        matchs = new ArrayList<Match>();
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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public List<Match> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<Match> matchs) {
        this.matchs = matchs;
    }

    public void addMatch(Match match) {
        matchs.add(match);
    }


}
