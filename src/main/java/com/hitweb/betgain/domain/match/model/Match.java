package com.hitweb.betgain.domain.match.model;

import com.hitweb.betgain.domain.bet.model.Odd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Match {
    private long id;

    private Date date;

    private List<Odd> odds = new ArrayList<Odd>();

    private Competition competition;

    private Opponent homeTeam;
    private Opponent awayTeam;

    public Match(long id, Date date, Opponent homeTeam, Opponent awayTeam) {
        this.id = id;
        this.date = date;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
    }

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

    public List<Odd> getOdds() {
        return odds;
    }

    public void setOdds(List<Odd> odds) {
        this.odds = odds;
    }
    public void addOdd(Odd odd){
        odds.add(odd);
    }

    public Opponent getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Opponent homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Opponent getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Opponent awayTeam) {
        this.awayTeam = awayTeam;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }
}
