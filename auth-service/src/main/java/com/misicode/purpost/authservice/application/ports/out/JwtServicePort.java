package com.misicode.purpost.authservice.application.ports.out;

public interface JwtServicePort {
    String generateJwtToken(String username);

    boolean isValidJwtToken(String token);

    String extractUsername(String token);
}
