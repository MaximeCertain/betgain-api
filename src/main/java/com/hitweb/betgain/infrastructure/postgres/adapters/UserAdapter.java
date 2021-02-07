package com.hitweb.betgain.infrastructure.postgres.adapters;

import com.hitweb.betgain.domain.user.model.Client;
import com.hitweb.betgain.domain.user.model.ERole;
import com.hitweb.betgain.domain.user.model.Role;
import com.hitweb.betgain.domain.user.model.User;
import com.hitweb.betgain.infrastructure.postgres.entities.RoleEntity;
import com.hitweb.betgain.infrastructure.postgres.entities.UserEntity;

import java.util.Set;
import java.util.stream.Collectors;

public class UserAdapter {

    public static UserEntity adapt(User user) {

        UserEntity userEntity = new UserEntity();
        userEntity.setId(user.getId());
        userEntity.setEmail(user.getEmail());
        userEntity.setFirstname(user.getFirstname());
        userEntity.setLastname(user.getLastname());
        userEntity.setPassword(user.getPassword());
        userEntity.setUsername(user.getUsername());
        userEntity.setConfirmationCode(user.getConfirmationCode());
        userEntity.setStrikeOff(user.isStrikeOff());
        userEntity.setValidated(user.isValidated());

        if (user.getRoles().size() > 0) {
            Set<RoleEntity> roleEntitySet = user.getRoles().stream().map(role -> RoleAdapter.adapt(role)).collect(Collectors.toSet());
            userEntity.setRoles(roleEntitySet);
        }

        if (user instanceof Client) {
            userEntity.setCardNumber(((Client) user).getCardNumber());
            userEntity.setExpirationDate(((Client) user).getExpirationDate());
            userEntity.setVisualCryptogram(((Client) user).getVisualCryptogram());
            userEntity.setCapital(((Client) user).getCapital());
        }

        return userEntity;

    }

    public static User reverse(UserEntity userEntity) {

        User user = new User();

        if(userEntity.hasRole(ERole.ROLE_USER)){
            user = new Client();
            ((Client) user).setExpirationDate(userEntity.getExpirationDate());
            ((Client) user).setCardNumber(userEntity.getCardNumber());
            ((Client) user).setVisualCryptogram(userEntity.getVisualCryptogram());
            ((Client) user).setCapital(userEntity.getCapital());
        }

        user.setId(userEntity.getId());
        user.setEmail(userEntity.getEmail());
        user.setFirstname(userEntity.getFirstname());
        user.setLastname(userEntity.getLastname());
        user.setPassword(userEntity.getPassword());
        user.setUsername(userEntity.getUsername());
        user.setConfirmationCode(userEntity.getConfirmationCode());
        user.setStrikeOff(userEntity.isStrikeOff());
        user.setValidated(userEntity.isValidated());

        if (userEntity.getRoles().size() > 0) {
            Set<Role> roleEntitySet = userEntity.getRoles().stream().map(role -> RoleAdapter.reverse(role)).collect(Collectors.toSet());
            user.setRoles(roleEntitySet);
        }

        return user;
    }
}
