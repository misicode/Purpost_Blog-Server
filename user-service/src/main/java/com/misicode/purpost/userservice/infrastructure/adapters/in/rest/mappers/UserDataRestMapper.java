package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.userservice.domain.model.User;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response.UserDataResponse;

public class UserDataRestMapper {
    private UserDataRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserDataResponse toUserDataResponse(User user) {
        return new UserDataResponse(
                user.getUsername(),
                user.getPassword(),
                user.getIdRole()
        );
    }
}
