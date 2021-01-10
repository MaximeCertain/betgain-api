package com.hitweb.betgain.infrastructure.postgres.repository.user;

import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import com.sun.el.stream.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRoleRepository extends JpaRepository<RoleEntity, Long> {
    <Optional>RoleEntity findByName(ERole name);
}
