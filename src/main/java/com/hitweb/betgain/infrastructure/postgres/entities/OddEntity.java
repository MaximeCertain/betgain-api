package com.hitweb.betgain.infrastructure.postgres.entities;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "odd")
public class OddEntity {

    @Id
    @Column(name = "odd_id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "label")
    private String label;

    @Column(name = "value")
    private float value;

    @ManyToOne(targetEntity = OddTypeEntity.class)
    @JoinColumn(name = "odd_type_id", nullable = false)
    private OddTypeEntity oddType;

    @ManyToOne(targetEntity = MatchEntity.class)
    @JoinColumn(name = "match_id", nullable = false)
    private MatchEntity matchEntity;

    @Column(name = "code")
    private String code;

    @Column(name = "date")
    private Date date;

    @Column(name = "validated")
    private boolean validated = false;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public OddTypeEntity getOddType() {
        return oddType;
    }

    public void setOddType(OddTypeEntity oddType) {
        this.oddType = oddType;
    }

    public MatchEntity getMatchEntity() {
        return matchEntity;
    }

    public void setMatchEntity(MatchEntity matchEntity) {
        this.matchEntity = matchEntity;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }
}
