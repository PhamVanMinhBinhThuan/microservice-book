package com.ltfullstack.employeeservice.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
    info = @Info(
        title = "Employee Api Specification - LT Fullstack",
        description = "Api documentation for Employee Service",
        version = "1.0",
        contact = @Contact(
            name = "Pham Van Minh",
            email = "pvminh23@clc.fitus.edu.vn",
            url = "https://github.com/PhamVanMinhBinhThuan"
        ),
        license = @License(
            name = "MIT License",
            url = "https://github.com/PhamVanMinhBinhThuan/licenses"
        ),
        termsOfService = "https://github.com/PhamVanMinhBinhThuan/terms"
    ),
    servers = {
        @Server(
            description = "Local ENV",
            url = "http://localhost:9003"
        ),
        @Server(
            description = "Dev ENV",
            url = "http://employee-service-dev.com"
        ),
        @Server(
            description = "Prod ENV",
            url = "http://employee-service-prod.com"
        )

    }
)
public class OpenApiConfig {
    
}
