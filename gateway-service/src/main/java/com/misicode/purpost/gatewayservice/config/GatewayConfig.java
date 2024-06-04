package com.misicode.purpost.gatewayservice.config;

import com.misicode.purpost.gatewayservice.filter.JwtAuthenticationFilter;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r.path("/api/v1/auth/**")
                        .uri("http://localhost:8090"))
                .route("post-service", r -> r.path("/api/v1/post/**")
                        .filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("http://localhost:10090"))
                .route("user-service", r -> r.path("/api/v1/user/**")
                        .filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("http://localhost:11090"))
                .build();
    }
}
