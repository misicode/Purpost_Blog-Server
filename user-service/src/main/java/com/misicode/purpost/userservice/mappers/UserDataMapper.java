package com.misicode.purpost.userservice.mappers;

import com.misicode.purpost.userservice.domain.User;
import com.misicode.purpost.userservice.dto.UserDataResponse;

public class UserDataMapper {
    private UserDataMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserDataResponse mapToUserDataResponse(User user) {
        return new UserDataResponse(
                user.getEmail(),
                user.getPassword(),
                user.getRole().getName().name()
        );
    }
}
