package com.misicode.purpost.authservice.services;

import com.misicode.purpost.authservice.client.UserClient;
import com.misicode.purpost.authservice.dto.UserResponse;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserClient userClient;

    public UserDetailsServiceImpl(UserClient userClient) {
        this.userClient = userClient;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserResponse user = userClient.getUserByEmail(email);

        if(user == null) {
            throw new UsernameNotFoundException("El usuario con correo " + email + " no existe");
        }

        return UserDetailsImpl.build(user);
    }
}