package com.example.playground.utils;

import com.example.playground.domain.Member;
import com.example.playground.domain.repository.MemberRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(2)
@Component
public class DataLoader2 implements CommandLineRunner {
    private final MemberRepository memberRepository;

    public DataLoader2(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void run(final String... args) throws Exception {
        memberRepository.save(new Member("jys"));
    }
}
