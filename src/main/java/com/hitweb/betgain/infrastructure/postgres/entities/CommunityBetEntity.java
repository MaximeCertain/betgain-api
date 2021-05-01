package com.hitweb.betgain.infrastructure.postgres.entities;

import javax.persistence.*;

@Entity
@Table(name = "community_bet")
public class CommunityBetEntity {
    @Id
    @Column(name = "community_bet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "treshold")
    private float treshold;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getTreshold() {
        return treshold;
    }

    public void setTreshold(float treshold) {
        this.treshold = treshold;
    }
}
