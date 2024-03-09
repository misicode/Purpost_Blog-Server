package com.misicode.purpost.authservice.services.user;

import com.misicode.purpost.authservice.domain.User;
import com.misicode.purpost.authservice.dto.UserCreateRequest;
import com.misicode.purpost.authservice.dto.UserUpdateRequest;

public interface IUserService {
    User getUserByEmail(String email);

    User createUser(UserCreateRequest userRequest);

    User updateUser(UserUpdateRequest userRequest, String email);
}
