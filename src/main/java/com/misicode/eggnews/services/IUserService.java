package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserDto;

public interface IUserService {
    UserDto getUserByEmail(String email);

    Boolean registerUser(User user);

    void saveUser(User user);
}
