package com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.mappers;

import com.misicode.purpost.userservice.domain.model.User;
import com.misicode.purpost.userservice.infrastructure.adapters.out.persistence.entity.UserEntity;

public class UserPersistenceMapper {
    public UserPersistenceMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserEntity toUserEntity(User user) {
        return UserEntity.builder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .names(user.getNames())
                .surnames(user.getSurnames())
                .isActive(user.getIsActive())
                .idRole(user.getIdRole())
                .createdAt(user.getCreatedAt())
                .updatedAt(user.getUpdatedAt())
                .build();
    }

    public static User toUser(UserEntity userEntity) {
        return User.builder()
                .idUser(userEntity.getIdUser())
                .username(userEntity.getUsername())
                .email(userEntity.getEmail())
                .password(userEntity.getPassword())
                .names(userEntity.getNames())
                .surnames(userEntity.getSurnames())
                .isActive(userEntity.getIsActive())
                .idRole(userEntity.getIdRole())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .build();
    }
}
