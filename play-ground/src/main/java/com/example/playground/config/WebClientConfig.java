package com.example.playground.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
    @Value("${mock-webserver.port}")
    private String portNum;

    @Bean
    public WebClient bankWebClient() {
        return WebClient.builder()
                .baseUrl("http://localhost:" + portNum)
                .build();
    }
}
