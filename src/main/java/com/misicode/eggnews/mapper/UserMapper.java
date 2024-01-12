package com.misicode.eggnews.mapper;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserDto;

public class UserMapper {
    public static UserDto mapToUserDto(User user) {
        return new UserDto(
                user.getIdUser(),
                user.getEmail(),
                user.getNames(),
                user.getSurnames()
        );
    }
}
