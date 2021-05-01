package com.hitweb.betgain.domain.bet.model;

import java.util.List;

public class CommunityBet extends Bet {
    private long id;
    private float threshold;
    private List<Bet> bets;

    public CommunityBet(long id, float threshold) {
        this.id = id;
        this.threshold = threshold;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getThreshold() {
        return threshold;
    }

    public void setThreshold(float threshold) {
        this.threshold = threshold;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
