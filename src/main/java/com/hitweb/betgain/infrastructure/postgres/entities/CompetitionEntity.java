package com.hitweb.betgain.infrastructure.postgres.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "competition")
public class CompetitionEntity {

    @Id
    @Column(name = "competition_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @JsonManagedReference
    @OneToMany(targetEntity = MatchEntity.class, mappedBy = "competition", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<MatchEntity> matchs = new ArrayList<>();


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MatchEntity> getMatchs() {
        return matchs;
    }

    public void setMatchs(List<MatchEntity> matchs) {
        this.matchs = matchs;
    }
}
