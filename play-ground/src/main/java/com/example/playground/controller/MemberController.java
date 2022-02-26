package com.example.playground.controller;

import com.example.playground.domain.Member;
import com.example.playground.service.MemberService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;


@RestController
@RequestMapping("/api/member")
public class MemberController {

    private final MemberService memberService;

    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Member.Response> getMember(@PathVariable final Long id) {
        return ResponseEntity.ok(memberService.getMemberById(id));
    }

    @PostMapping
    public ResponseEntity<Member.Response> create(@RequestBody final Member.Request request) {
        Member.Response memberResponse = memberService.create(request);
        return ResponseEntity.created(URI.create(String.format("/api/member/%d", memberResponse.getId())))
                .body(memberResponse);
    }
}