package com.misicode.eggnews.services.user;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.user.UserCreateRequest;
import com.misicode.eggnews.dto.user.UserUpdateRequest;

public interface IUserService {
    User getUserByEmail(String email);

    User createUser(UserCreateRequest userRequest);

    User updateUser(UserUpdateRequest userRequest, String email);
}
