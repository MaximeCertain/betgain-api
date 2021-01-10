package com.hitweb.betgain.infrastructure.services.auth.payload.request;

import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SignUpRequest {
    private String username;
    private String password;
    private String email;
    private List<RoleEntity> roles;
    private String firstname;
    private String lastname;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<RoleEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RoleEntity> roles) {
        this.roles = roles;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
}
