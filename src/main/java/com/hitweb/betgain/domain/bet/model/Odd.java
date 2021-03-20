package com.hitweb.betgain.domain.bet.model;

import com.hitweb.betgain.domain.match.model.Match;
import com.hitweb.betgain.domain.match.model.Opponent;

import java.util.Date;

public class Odd {

    private long id;
    private OddType oddType;
    private float value;
    private boolean validated;
    private String code;
    private Match match;
    private Date date;


    public Odd(OddType oddType, float value, long id, Date date) {
        this.oddType = oddType;
        this.value = value;
        this.id = id;
        this.date = date;
    }

    public OddType getOddType() {
        return oddType;
    }

    public void setOddType(OddType oddType) {
        this.oddType = oddType;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

   /* public String getLabel() throws Exception {
        switch (oddType.getCode()) {
            case AWAY_TEAM_WON:
                return "Victoire de l'équipe";
            case HOME_TEAM_WON:
                return "victoire";
            default:
                throw new Exception();
        }
    }*/

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void validateResult(Opponent homeTeam, Opponent awayTeam) {
        switch (this.oddType.getCode()) {
            case HOME_TEAM_WON:
                if (homeTeam.getGoalsNumber() > awayTeam.getGoalsNumber()) {
                    this.validated = true;
                }
            case AWAY_TEAM_WON:
                if (awayTeam.getGoalsNumber() > homeTeam.getGoalsNumber()) {
                    this.validated = true;
                }
            case DRAW:
                if (awayTeam.getGoalsNumber() == homeTeam.getGoalsNumber()) {
                    this.validated = true;
                }
        }
    }
}
