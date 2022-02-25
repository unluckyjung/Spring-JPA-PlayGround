package com.example.playground.domain.repository;

import com.example.playground.domain.Member;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@Slf4j
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @BeforeEach
    void setUp() {
        memberRepository.save(new Member("unluckyjung"));
    }

    @Test
    void memberGetTest() {
        Member member = getMember("unluckyjung");

        //..추가적인 비즈니스 로직..

        assertThat(memberRepository.findAll().size()).isEqualTo(1);
    }

    private Member getMember(final String name) {
        return memberRepository.findByName(name).orElse(saveMember(name));  // fail case
//        return memberRepository.findByName(name).orElseGet(() -> saveMember(name));   // success case
    }

    private Member saveMember(final String name) {
        log.info("saveMember run!!");
        return memberRepository.save(new Member(name));
    }
}