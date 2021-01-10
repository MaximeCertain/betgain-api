package com.hitweb.betgain.domain.user.repository;

import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;

public interface RoleRepository {
    public Iterable<Role> findAll();
}
