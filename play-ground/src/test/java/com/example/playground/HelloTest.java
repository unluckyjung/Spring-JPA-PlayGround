package com.example.playground;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class HelloTest {

    @Test
    void helloTest() {
        String hello = "hello";
        assertThat(hello).isEqualTo("hello");
    }
}
