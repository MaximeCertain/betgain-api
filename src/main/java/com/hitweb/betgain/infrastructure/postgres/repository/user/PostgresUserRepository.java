package com.hitweb.betgain.infrastructure.postgres.repository.user;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.repository.UserRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.UserAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PostgresUserRepository implements UserRepository {

    private final JpaUserRepository jpaUserRepository;

    @Autowired
    public PostgresUserRepository(JpaUserRepository jpaUserRepository) {
        this.jpaUserRepository = jpaUserRepository;
    }

    @Override
    public void save(User user) {

        UserEntity userEntityJpa = UserAdapter.adapt(user);
        jpaUserRepository.save(userEntityJpa);
    }

    @Override
    public Iterable<User> findAll() {
        List<User> users = jpaUserRepository.findAll().stream().map(user -> UserAdapter.reverse(user)).collect(Collectors.toList());
        return users;
    }
}
