package com.hitweb.betgain.domain.user.model;

import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;

import java.util.HashSet;
import java.util.Set;

public class User {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private String confirmationCode;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

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

    public Set<Role> getRoles() {
        return roles;
    }

    public void addRole(Role role) {
        this.roles.add(role);
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public boolean hasRole(ERole eRole) {
        for (Role role : this.roles) {
            if (eRole == role.getName()) return true;
        }
        return false;
    }

    public String getConfirmationCode() {
        return confirmationCode;
    }

    public void setConfirmationCode(String confirmationCode) {
        this.confirmationCode = confirmationCode;
    }

}
