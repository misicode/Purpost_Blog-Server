package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.User;

public interface IUserService {
    User getUserByEmail(String email);

    Boolean saveUser(User user);
}
