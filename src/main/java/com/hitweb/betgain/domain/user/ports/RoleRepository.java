package com.hitweb.betgain.domain.user.ports;

import com.hitweb.betgain.domain.user.model.Role;

public interface RoleRepository {
    public Iterable<Role> findAll();
}
