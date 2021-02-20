package com.hitweb.betgain.domain.match.model;

public class Opponent extends Team {

    private EOpponent type;
    private int goalsNumber;
    private int yellowCardNumber;
    private int redCardNumber;

    public Opponent(EOpponent type, long id, String name, String logo, String code, int goalsNumber, int yellowCardNumber, int redCardNumber) {
        super(id, name, logo, code);
        this.type = type;
        this.type = type;
        this.goalsNumber = goalsNumber;
        this.yellowCardNumber = yellowCardNumber;
        this.redCardNumber = redCardNumber;


    }
    public EOpponent getType() {
        return type;
    }

    public void setType(EOpponent type) {
        this.type = type;
    }

    public int getGoalsNumber() {
        return goalsNumber;
    }

    public void setGoalsNumber(int goalsNumber) {
        this.goalsNumber = goalsNumber;
    }

    public int getYellowCardNumber() {
        return yellowCardNumber;
    }

    public void setYellowCardNumber(int yellowCardNumber) {
        this.yellowCardNumber = yellowCardNumber;
    }

    public int getRedCardNumber() {
        return redCardNumber;
    }

    public void setRedCardNumber(int redCardNumber) {
        this.redCardNumber = redCardNumber;
    }
}
