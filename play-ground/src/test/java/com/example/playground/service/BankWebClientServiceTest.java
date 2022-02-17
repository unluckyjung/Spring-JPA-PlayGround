package com.example.playground.service;

import com.example.playground.MockWebServerAndWebClientTest;
import okhttp3.mockwebserver.MockResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import static org.assertj.core.api.Assertions.assertThat;

class BankWebClientServiceTest extends MockWebServerAndWebClientTest {

    @Autowired
    private BankWebClientService bankWebClientService;

    @Test
    void resultBodyTest() {
        String inputStr = "this is YoonSung Body";
        MockResponse mockResponse = new MockResponse()
                .setResponseCode(HttpStatus.OK.value())
                .setBody(inputStr);

        mockWebServer.enqueue(mockResponse);

        assertThat(inputStr).isEqualTo(bankWebClientService.getResultBody());
    }
}