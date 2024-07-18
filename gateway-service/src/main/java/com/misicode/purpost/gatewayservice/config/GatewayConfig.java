package com.misicode.purpost.gatewayservice.config;

import com.misicode.purpost.gatewayservice.filter.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {
    private final JwtAuthenticationFilter jwtAuthFilter;

    @Value("${AUTH_HOST:localhost}")
    private String authServiceHost;

    @Value("${IMAGE_HOST:localhost}")
    private String imageServiceHost;

    @Value("${POST_HOST:localhost}")
    private String postServiceHost;

    @Value("${USER_HOST:localhost}")
    private String userServiceHost;

    public GatewayConfig(JwtAuthenticationFilter jwtAuthFilter) {
        this.jwtAuthFilter = jwtAuthFilter;
    }

    @Bean
    public RouteLocator routes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("auth-service", r -> r
                        .path("/api/v1/auth/**")
                        .uri("http://" + authServiceHost + ":8090"))
                .route("image-service", r -> r
                        .path("/api/v1/image/private/**")
                        .filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("http://" + imageServiceHost + ":9090"))
                .route("post-service", r -> r
                        .path("/api/v1/post/private/**")
                        .filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("http://" + postServiceHost + ":10090"))
                .route("user-service", r -> r
                        .path("/api/v1/user/private/**")
                        .filters(f -> f.filter(jwtAuthFilter.apply(new JwtAuthenticationFilter.Config())))
                        .uri("http://" + userServiceHost + ":11090"))
                .build();
    }
}
