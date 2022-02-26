package com.example.playground.service;

import com.example.playground.domain.Member;
import com.example.playground.domain.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional(readOnly = true)
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberService(final MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public Member.Response create(final Member.Request request) {
        return Member.Response.from(
                memberRepository.save(new Member(request.getName()))
        );
    }

    public Member.Response getMemberById(final Long id) {
        return Member.Response.from(
                memberRepository.findById(id)
                        .orElseThrow(() -> new IllegalArgumentException(String.format("없는 회원 id 입니다. id : %d", id)))
        );
    }
}
