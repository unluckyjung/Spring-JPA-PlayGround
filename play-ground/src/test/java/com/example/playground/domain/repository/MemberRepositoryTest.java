package com.example.playground.domain.repository;

import com.example.playground.domain.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Java6Assertions.assertThat;

@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    private MemberRepository memberRepository;

    @Test
    void memberSaveTest() {
        Member member = new Member("jys");
        Member savedMember = memberRepository.save(member);

        Optional<Member> loadMember = memberRepository.findById(savedMember.getId());
        assertThat(savedMember).isEqualTo(loadMember.get());
    }
}