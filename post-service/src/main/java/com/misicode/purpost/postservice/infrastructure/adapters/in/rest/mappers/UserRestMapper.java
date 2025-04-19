package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response.UserResponse;

public class UserRestMapper {
    public UserRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .names(user.getNames())
                .surnames(user.getSurnames())
                .build();
    }
}
