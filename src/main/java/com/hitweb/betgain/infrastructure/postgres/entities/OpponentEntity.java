package com.hitweb.betgain.infrastructure.postgres.entities;

import javax.persistence.*;

@Entity
@Table(name = "opponent")
public class OpponentEntity {
    @Id
    @Column(name = "opponent_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "goals_number")
    private int goalsNumber;

    @Column(name = "yellow_card_number")
    private int yellowCardNumber;

    @Column(name = "red_card_number")
    private int redCardNumber;

    @Column(name = "type")
    private String type;

    @OneToOne(targetEntity = TeamEntity.class)
    @JoinColumn(name = "team_id", nullable = false)
    private TeamEntity team;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public TeamEntity getTeam() {
        return team;
    }

    public void setTeam(TeamEntity team) {
        this.team = team;
    }
}
