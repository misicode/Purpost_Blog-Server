package com.misicode.purpost.userservice.mappers;

import com.misicode.purpost.userservice.domain.User;
import com.misicode.purpost.userservice.dto.UserResponse;

public class UserMapper {
    private UserMapper() {
        throw new UnsupportedOperationException();
    }

    public static UserResponse mapToUserResponse(User user) {
        return new UserResponse(
                user.getIdUser(),
                user.getUsername(),
                user.getEmail(),
                user.getNames(),
                user.getSurnames(),
                user.getRole().getName().name()
        );
    }
}
