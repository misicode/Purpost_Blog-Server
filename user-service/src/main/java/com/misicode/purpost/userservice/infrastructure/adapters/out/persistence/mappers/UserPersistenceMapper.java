package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.userservice.domain.model.User;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity.UserEntity;

public class UserPersistenceMapper {
    public UserPersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserEntity toUserEntity(User user) {
        return new UserEntity(
                user.getIdUser(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getNames(),
                user.getSurnames(),
                user.getActive(),
                user.getIdRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }

    public static User toUser(UserEntity userEntity) {
        return new User(
                userEntity.getIdUser(),
                userEntity.getUsername(),
                userEntity.getEmail(),
                userEntity.getPassword(),
                userEntity.getNames(),
                userEntity.getSurnames(),
                userEntity.getActive(),
                userEntity.getIdRole(),
                userEntity.getCreatedAt(),
                userEntity.getUpdatedAt()
        );
    }
}
