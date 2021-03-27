package com.hitweb.betgain.infrastructure.postgres.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "match")
public class MatchEntity {
    @Id
    @Column(name = "match_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date")
    private Date date;

    @Column(name = "code")
    private String code;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = {CascadeType.ALL})
    @JoinColumn(name = "competition_id", nullable = false)
    private CompetitionEntity competition;

    @JsonManagedReference
    @OneToMany(targetEntity = OddEntity.class, fetch = FetchType.EAGER)
    private List<OddEntity> odds = new ArrayList<>();

    @OneToOne(targetEntity = OpponentEntity.class)
    @JoinColumn(name = "away_team_id", nullable = false)
    private OpponentEntity awayTeam;

    @OneToOne(targetEntity = OpponentEntity.class)
    @JoinColumn(name = "home_team_id", nullable = false)
    private OpponentEntity homeTeam;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<OddEntity> getOdds() {
        return odds;
    }

    public void setOdds(List<OddEntity> odds) {
        this.odds = odds;
    }

    public OpponentEntity getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(OpponentEntity awayTeam) {
        this.awayTeam = awayTeam;
    }

    public OpponentEntity getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(OpponentEntity homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public CompetitionEntity getCompetition() {
        return competition;
    }

    public void setCompetition(CompetitionEntity competition) {
        this.competition = competition;
    }
}
