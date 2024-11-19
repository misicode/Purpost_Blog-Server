package com.misicode.purpost.authservice.application.services;

import com.misicode.purpost.authservice.application.ports.out.UserWebClientPort;
import com.misicode.purpost.authservice.domain.model.UserDetailsImpl;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class UserDetailsServiceImpl implements ReactiveUserDetailsService {
    private final UserWebClientPort userWebClientPort;

    public UserDetailsServiceImpl(UserWebClientPort userWebClientPort) {
        this.userWebClientPort = userWebClientPort;
    }

    @Override
    public Mono<UserDetails> findByUsername(String account) {
        return userWebClientPort
                .findByUsernameOrEmail(account)
                .switchIfEmpty(Mono.error(
                        new UsernameNotFoundException("El nombre de usuario o correo " + account + " no existe")
                ))
                .map(UserDetailsImpl::build);
    }
}