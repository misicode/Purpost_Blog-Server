package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserResponse;

public class UserMapper {
    public static UserResponse mapToUserResponse(User user) {
        return new UserResponse(
                user.getIdUser(),
                user.getEmail(),
                user.getNames(),
                user.getSurnames()
        );
    }
}
