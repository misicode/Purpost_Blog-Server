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
        return new User(
                null,
                user.username(),
                user.email(),
                user.password(),
                user.names(),
                user.surnames(),
                null,
                null,
                null,
                null
        );
    }

    public static User toUser(UserUpdateRequest user) {
        return new User(
                null,
                user.username(),
                null,
                null,
                user.names(),
                user.surnames(),
                null,
                null,
                null,
                null
        );
    }

    public static UserResponse toUserResponse(User user) {
        return new UserResponse(
                user.getIdUser(),
                user.getUsername(),
                user.getEmail(),
                user.getNames(),
                user.getSurnames(),
                user.getIdRole()
        );
    }
}
