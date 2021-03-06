package com.hitweb.betgain.infrastructure.postgres.entities;

import javax.persistence.*;

@Entity
@Table(name = "bet_state")
public class BetStateEntity {
    @Id
    @Column(name = "bet_state_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "code")
    private String code;
    @Column(name = "label")
    private String label;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
