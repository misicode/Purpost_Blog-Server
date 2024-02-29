package com.misicode.eggnews.payload;

import com.misicode.eggnews.dto.user.UserResponse;

public class SigninResponse {
    private String token;
    private UserResponse user;

    public SigninResponse(String token, UserResponse user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public UserResponse getUser() {
        return user;
    }
}
