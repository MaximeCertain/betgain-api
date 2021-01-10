package com.hitweb.betgain.infrastructure.postgres.entities;

import com.hitweb.betgain.domain.user.model.ERole;
import javax.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="role")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    private long id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private ERole name;

    public RoleEntity(ERole name){
        this.name = name;
    }

    public RoleEntity() {

    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ERole getName() {
        return name;
    }

    public void setName(ERole name) {
        this.name = name;
    }

}
