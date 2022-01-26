package com.example.playground.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

class MemberTest {

    @Test
    void nameTest() {
        Member member = new Member("jys");
        assertThat(member.getName()).isEqualTo("jys");
    }
}