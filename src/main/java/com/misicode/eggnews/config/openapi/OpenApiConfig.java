package com.misicode.eggnews.config.openapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(
                title = "EggNews API",
                version = "1.0.0",
                description = "EggNews API REST desarrollado con Spring Boot, Spring Security y JWT.",
                termsOfService = "http://swagger.io/terms/",
                license = @License(name = "Licencia Apache 2.0", url = "http://www.apache.org/licenses/LICENSE-2.0")
        )
)
public class OpenApiConfig {
}
