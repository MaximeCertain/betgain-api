package com.hitweb.betgain.infrastructure.postgres.repository.user;

import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.repository.RoleRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.RoleAdapter;
import com.hitweb.betgain.infrastructure.postgres.adapters.UserAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostgresRoleRepository implements RoleRepository {

    private final JpaRoleRepository jpaRoleRepository;

    @Autowired
    public PostgresRoleRepository(JpaRoleRepository jpaUserRepository) {
        this.jpaRoleRepository = jpaUserRepository;
    }

    @Override
    public Iterable<Role> findAll() {
        List<Role> roles = jpaRoleRepository.findAll().stream().map(role -> RoleAdapter.reverse(role)).collect(Collectors.toList());
        return roles;
    }
}
