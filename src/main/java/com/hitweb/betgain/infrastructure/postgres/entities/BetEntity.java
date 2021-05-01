package com.hitweb.betgain.infrastructure.postgres.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "bet")
public class BetEntity {
    @Id
    @Column(name = "bet_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "amount")
    private float amount;

    @Column(name = "date")
    private Date date;

    @ManyToOne(targetEntity = UserEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne(targetEntity = OddEntity.class)
    @JoinColumn(name = "odd_id", nullable = false)
    private OddEntity odd;

    @ManyToOne(targetEntity = BetStateEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "bet_state_id", nullable = true)
    private BetStateEntity betState;

    @ManyToOne(targetEntity = CommunityBetEntity.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "community_bet_id", nullable = true)
    private CommunityBetEntity communityBetEntity;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public OddEntity getOdd() {
        return odd;
    }

    public void setOdd(OddEntity odd) {
        this.odd = odd;
    }

    public BetStateEntity getBetState() {
        return betState;
    }

    public void setBetState(BetStateEntity betState) {
        this.betState = betState;
    }

    public CommunityBetEntity getCommunityBetEntity() {
        return communityBetEntity;
    }

    public void setCommunityBetEntity(CommunityBetEntity communityBetEntity) {
        this.communityBetEntity = communityBetEntity;
    }
}
