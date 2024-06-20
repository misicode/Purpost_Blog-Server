package com.misicode.purpost.userservice.services.user;

import com.misicode.purpost.userservice.domain.User;
import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;

public interface IUserService {
    User getUserById(String id);

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    User getUserByUsernameOrEmail(String account);

    User createUser(UserCreateRequest userRequest);

    User updateUser(UserUpdateRequest userRequest);
}
