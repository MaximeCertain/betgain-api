package com.hitweb.betgain.infrastructure.postgres.repository.user;

import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JpaUserRepository extends JpaRepository<UserEntity, Long>
{
    Optional<UserEntity> findByUsername(String username);
    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
    UserEntity findById(long id);

}
