package com.hitweb.betgain.domain.bet.model;

import com.hitweb.betgain.domain.match.model.Match;

public class Odd {
    private long id;
    private OddType oddType;
    private float value;
    private boolean validated;
    private String code;

    private Match match;

    public Odd(OddType oddType, float value, long id) {
        this.oddType = oddType;
        this.value = value;
        this.id = id;

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
}
