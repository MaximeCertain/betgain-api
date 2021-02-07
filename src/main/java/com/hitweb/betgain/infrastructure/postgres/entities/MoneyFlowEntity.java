package com.hitweb.betgain.infrastructure.postgres.entities;


import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "money_flow")
public class MoneyFlowEntity {
    @Id
    @Column(name = "money_flow_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "amount")
    private float amount;
    @Column(name = "date")
    private Date date;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn( name="money_flow_state_id")
    private MoneyFlowStateEntity moneyFlowState;

    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="user_id")
    private UserEntity user;

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

    public MoneyFlowStateEntity getMoneyFlowState() {
        return moneyFlowState;
    }

    public void setMoneyFlowState(MoneyFlowStateEntity moneyFlowState) {
        this.moneyFlowState = moneyFlowState;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }
}
