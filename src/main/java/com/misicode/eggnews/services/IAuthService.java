package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;

public interface IAuthService {
    SigninResponse login(SigninRequest signinRequest);

    User getUserAuthenticated();
}
