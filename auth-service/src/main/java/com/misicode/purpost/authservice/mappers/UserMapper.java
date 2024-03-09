package com.misicode.purpost.authservice.mappers;

import com.misicode.purpost.authservice.domain.User;
import com.misicode.purpost.authservice.dto.UserResponse;

public class UserMapper {
    private UserMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserResponse mapToUserResponse(User user) {
        return new UserResponse(
                user.getIdUser(),
                user.getEmail(),
                user.getNames(),
                user.getSurnames(),
                user.getRole().getName().name()
        );
    }
}
