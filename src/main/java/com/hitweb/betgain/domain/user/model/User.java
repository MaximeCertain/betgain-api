package com.hitweb.betgain.domain.user.model;

import com.hitweb.betgain.domain.user.ports.UserInterface;

import java.util.HashSet;
import java.util.Set;

public class User implements UserInterface {

    private long id;
    private String firstname;
    private String lastname;
    private String email;
    private String username;
    private String password;
    private Set<Role> roles = new HashSet<>();
    private String confirmationCode;
    private boolean validated = false;
    private boolean strikeOff = false;

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

    public boolean isValidated() {
        return validated;
    }

    public void setValidated(boolean validated) {
        this.validated = validated;
    }

    public boolean isStrikeOff() {
        return strikeOff;
    }

    public void setStrikeOff(boolean strikeOff) {
        this.strikeOff = strikeOff;
    }
}
