package com.example.playground.utils;

import com.example.playground.domain.Member;
import com.example.playground.domain.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class DataLoader implements CommandLineRunner {
    private final MemberRepository memberRepository;

    public DataLoader(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        memberRepository.save(new Member("unluckyjung"));
    }
}
