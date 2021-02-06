package com.hitweb.betgain.infrastructure.postgres.repository.user;

import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.domain.user.ports.UserRepository;
import com.hitweb.betgain.infrastructure.postgres.adapters.UserAdapter;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;
import com.hitweb.betgain.infrastructure.services.mail.EmailServiceImpl;
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


    @Autowired
    EmailServiceImpl emailService;

    @Override
    public User save(User user) {

        UserEntity userEntityJpa = UserAdapter.adapt(user);
        System.out.println(userEntityJpa.getVisualCryptogram());
        UserEntity newUser = jpaUserRepository.save(userEntityJpa);
        return UserAdapter.reverse(newUser);
    }

    @Override
    public Iterable<User> findAll() {
        List<User> users = jpaUserRepository.findAll().stream().map(user -> UserAdapter.reverse(user)).collect(Collectors.toList());
        return users;
    }

    @Override
    public User findUser(long id) {
        if((new Long(id)) == null) return null;

        UserEntity userEntity = jpaUserRepository.findById(id);
        return UserAdapter.reverse(userEntity);
    }
}
