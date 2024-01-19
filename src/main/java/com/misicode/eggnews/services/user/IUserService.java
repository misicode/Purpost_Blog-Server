package com.misicode.eggnews.services.user;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserDto;

public interface IUserService {
    User getUserByEmail(String email);

    Boolean registerUser(User user);

    User updateUser(UserDto user, String email);
}
