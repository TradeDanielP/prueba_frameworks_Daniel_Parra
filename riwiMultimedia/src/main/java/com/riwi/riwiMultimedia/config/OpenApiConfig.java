package com.riwi.riwiMultimedia.config;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;

@Configuration
@OpenAPIDefinition(info = @Info(
    title = "Riwi Multimedia", 
    version = "1.0", 
    description = "This API was created for manage the lessons and media in the courses of Riwi"),
    servers = {
                @Server(
                        description = "Local",
                        url = "http://localhost:8080/api/v1")
        })
public class OpenApiConfig {

}
