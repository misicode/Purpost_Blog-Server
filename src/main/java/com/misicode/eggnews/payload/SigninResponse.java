package com.misicode.eggnews.payload;

public class SigninResponse {
    private String token;
    private String email;

    public SigninResponse(String token, String email) {
        this.token = token;
        this.email = email;
    }

    public String getToken() {
        return token;
    }

    public String getEmail() {
        return email;
    }
}
