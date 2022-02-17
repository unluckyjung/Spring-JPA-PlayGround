package com.example.playground;

import lombok.extern.slf4j.Slf4j;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.io.IOException;


@Slf4j
@SpringBootTest
public
class MockWebServerAndWebClientTest {

    protected static MockWebServer mockWebServer;

    @BeforeAll
    static void setUp() throws IOException {
        mockWebServer = new MockWebServer();
        mockWebServer.start(9999);
    }

    @AfterAll
    static void tearDown() throws IOException {
        mockWebServer.shutdown();
    }

    @Test
    void callMockSever() {
        WebClient webClient = WebClient.builder()
                .baseUrl("http://localhost:9999")
                .build();

        MockResponse mockResponse = new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setBody("this is YoonSung Body");

        mockWebServer.enqueue(mockResponse);

        Mono<String> responseBody = webClient.get().retrieve().bodyToMono(String.class);

        System.out.println(responseBody.block());    // 결과 획득
    }
}