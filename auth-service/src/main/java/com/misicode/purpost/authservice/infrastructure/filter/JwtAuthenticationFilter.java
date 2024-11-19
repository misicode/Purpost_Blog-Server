package com.misicode.purpost.authservice.infrastructure.filter;

import com.misicode.purpost.authservice.application.ports.out.JwtServicePort;
import com.misicode.purpost.authservice.application.services.UserDetailsServiceImpl;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import reactor.core.publisher.Mono;

@Component
public class JwtAuthenticationFilter implements WebFilter {
    private final JwtServicePort jwtServicePort;
    private final UserDetailsServiceImpl userDetailsService;

    public JwtAuthenticationFilter(JwtServicePort jwtServicePort, UserDetailsServiceImpl userDetailsService) {
        this.jwtServicePort = jwtServicePort;
        this.userDetailsService = userDetailsService;
    }

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        String tokenHeader = exchange.getRequest().getHeaders().getFirst(HttpHeaders.AUTHORIZATION);

        if (tokenHeader != null && tokenHeader.startsWith("Bearer ")) {
            String token = tokenHeader.substring(7);

            if (jwtServicePort.isValidJwtToken(token)) {
                return jwtServicePort
                        .extractUsername(token)
                        .flatMap(userDetailsService::findByUsername)
                        .flatMap(userDetails -> {
                            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
                                    userDetails, null, userDetails.getAuthorities()
                            );
                            SecurityContextHolder.getContext().setAuthentication(authToken);
                            return chain.filter(exchange);
                        });
            }
        }

        return chain.filter(exchange);
    }
}