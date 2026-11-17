package com.tourism.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI tourismOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Tourism Analytics Dashboard API")
                        .description(
                            "API for managing tourist records.\n\n" +
                            "**Token Validation:** Pass the token in the custom `Token` header.\n\n" +
                            "**Valid Token:** `TOURISM-SECRET-TOKEN-2024`"
                        )
                        .version("1.0.0")
                        .contact(new Contact()
                                .name("Tourism Analytics Team")
                                .email("admin@tourism.com")))
                .components(new Components()
                        .addSecuritySchemes("TokenHeader",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.APIKEY)
                                        .in(SecurityScheme.In.HEADER)
                                        .name("Token")
                                        .description("Enter your pre-generated token: TOURISM-SECRET-TOKEN-2024")));
    }
}
