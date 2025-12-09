package com.jobportal.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.tags.Tag;

@Configuration
@OpenAPIDefinition(
    info = @Info(title = "JobPortal - Employee API", version = "1.0",
                 description = "Employee CRUD API for JobPortal"),
    tags = {
        @Tag(name = "Employee", description = "Operations related to Employee")
    }
)
public class SwaggerConfig { }