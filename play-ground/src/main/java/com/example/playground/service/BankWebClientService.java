package com.example.playground.service;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Component
public class BankWebClientService {
    private final WebClient webClient;

    public BankWebClientService(final WebClient webClient) {
        this.webClient = webClient;
    }

    public String getResultBody(){
        Mono<String> responseBody = webClient.get().retrieve().bodyToMono(String.class);
        return responseBody.block();
    }
}
