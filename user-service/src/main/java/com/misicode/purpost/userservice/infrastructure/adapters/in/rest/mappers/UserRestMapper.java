package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.userservice.domain.model.User;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request.UserCreateRequest;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request.UserUpdateRequest;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response.UserResponse;

public class UserRestMapper {
    private UserRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static User toUser(UserCreateRequest user) {
        return User.builder()
                .username(user.username())
                .email(user.email())
                .password(user.password())
                .names(user.names())
                .surnames(user.surnames())
                .build();

    }

    public static User toUser(UserUpdateRequest user) {
        return User.builder()
                .username(user.username())
                .names(user.names())
                .surnames(user.surnames())
                .build();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .email(user.getEmail())
                .names(user.getNames())
                .surnames(user.getSurnames())
                .idRole(user.getIdRole())
                .build();
    }
}
