package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class UserAdapter {

    public static UserEntity adapt(User user) {

        UserEntity userEntity = new UserEntity();

        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstName());
        userEntity.setLastname(user.getLastName());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());

        return userEntity;

    }

    public static User reverse(UserEntity userEntity) {

        User user = new User();
        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setFirstName(userEntity.getFirstname());
        user.setLastName(userEntity.getLastname());
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());

        if(userEntity.getRoles().size() > 0){
            Set<Role> roleEntitySet =  userEntity.getRoles().stream().map(role -> RoleAdapter.reverse(role)).collect(Collectors.toSet());
            user.setRoles(roleEntitySet);
        }

        return user;
    }
}
