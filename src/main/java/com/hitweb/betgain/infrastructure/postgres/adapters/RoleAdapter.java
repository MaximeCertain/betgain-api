package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;

import java.util.stream.Collectors;

public class RoleAdapter {



    public static Role reverse(RoleEntity roleEntity) {

        Role role = new Role();
        role.setId(roleEntity.getId());
        role.setName(roleEntity.getName());

        return role;
    }
}
