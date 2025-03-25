package com.techchallenge.tech_challenge_backend.config;

import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Tech Challenge API",
        version = "1.0",
        description = "Documentação da API do desafio técnico - Postech"
    )
)
public class OpenAPIConfig {
}
