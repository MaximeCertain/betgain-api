package com.hitweb.betgain.domain.bet.model;

public class Odd {
    private OddType oddType;
    private float value;
    private boolean validated;
    private String label;

    public Odd(OddType oddType, float value) {
        this.oddType = oddType;
        this.value = value;
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

    public String getLabel() throws Exception {
        switch (oddType.getCode()) {
            case AWAY_TEAM_WON:
                return "Victoire de l'équipe";
            case HOME_TEAM_WON:
                return "victoire";
            default:
                throw new Exception();
        }
    }

}
