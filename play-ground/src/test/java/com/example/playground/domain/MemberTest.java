package com.example.playground.domain;

import com.example.playground.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Java6Assertions.assertThat;

@SpringBootTest
class MemberTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void nameTest() {
        Member member = new Member("jys");
        Member savedMember = memberRepository.save(member);
        assertThat(member.getName()).isEqualTo(savedMember.getName());
    }
}