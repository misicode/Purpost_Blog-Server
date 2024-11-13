package com.misicode.purpost.imageservice.infrastructure.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class CloudinaryConfig {
    @Value("${cloudinary.cloud_name}")
    private String cloudName;

    @Bean
    public WebClient cloudinaryWebClient() {
        return WebClient
                .builder()
                .baseUrl("https://api.cloudinary.com/v1_1/" + cloudName)
                .build();
    }
}
