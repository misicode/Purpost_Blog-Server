package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.UserDetailsImpl;

public interface IAuthService {
    void login(UserDetailsImpl userDetails);
}
