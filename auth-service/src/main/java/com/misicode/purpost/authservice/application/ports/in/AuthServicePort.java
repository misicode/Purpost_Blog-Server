package com.misicode.purpost.authservice.application.ports.in;

import com.misicode.purpost.authservice.domain.model.Credentials;

public interface AuthServicePort {
    String login(Credentials credentials);

    String checkToken(String token);
}
