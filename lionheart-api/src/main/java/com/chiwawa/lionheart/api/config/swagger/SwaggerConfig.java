package com.chiwawa.lionheart.api.config.swagger;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI openAPI() {
		Info info = new Info()
			.title("LionHeart API Server")
			.description("LionHeart API Docs")
			.version("1.0.0");

		SecurityScheme securityScheme = new SecurityScheme()
			.type(SecurityScheme.Type.HTTP).scheme("bearer").bearerFormat("JWT")
			.in(SecurityScheme.In.HEADER).name("Authorization");
		SecurityRequirement securityRequirement = new SecurityRequirement().addList("Bearer Token");

		return new OpenAPI()
			.components(new Components().addSecuritySchemes("Bearer Token", securityScheme))
			.security(Arrays.asList(securityRequirement))
			.info(info);
	}

}
