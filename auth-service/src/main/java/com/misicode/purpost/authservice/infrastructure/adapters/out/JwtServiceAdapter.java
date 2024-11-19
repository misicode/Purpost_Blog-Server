package com.misicode.purpost.authservice.infrastructure.adapters.out;

import com.misicode.purpost.authservice.application.ports.out.JwtServicePort;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Service
public class JwtServiceAdapter implements JwtServicePort {
    @Value("${jwt.secret_key}")
    private String secretKey;

    @Value("${jwt.expiration_time}")
    private String expirationTime;

    @Override
    public Mono<String> generateJwtToken(String username) {
        return Mono.fromSupplier(() -> Jwts
                .builder()
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + Long.parseLong(expirationTime)))
                .signWith(getKey(), SignatureAlgorithm.HS256)
                .compact());
    }

    @Override
    public Boolean isValidJwtToken(String token) {
        try {
            getAllClaims(token);
            return true;
        } catch(Exception e) {
            System.out.println("Token inválido, ERROR: " + e.getMessage());
            return false;
        }
    }

    @Override
    public Mono<String> extractUsername(String token){
        return Mono.fromSupplier(() -> getClaim(token, Claims::getSubject));
    }

    public Key getKey() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secretKey));
    }

    public <T> T getClaim(String token, Function<Claims, T> claimsResolver){
        Claims claims = getAllClaims(token);
        return claimsResolver.apply(claims);
    }

    public Claims getAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
