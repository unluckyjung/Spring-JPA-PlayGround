package com.example.playground.controller;

import com.example.playground.domain.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api/member")
public class MemberController {

    @GetMapping("/{id}")
    public ResponseEntity<Member.Response> getMember(@PathVariable final Long id) {
        return ResponseEntity.ok(new Member.Response(id, "unluckyjung"));
    }

    @PostMapping
    public ResponseEntity<Member.Response> create(@RequestBody final Member.Request request) {
        //...저장로직
        return ResponseEntity.created(URI.create(String.format("/api/member/%d", 1L)))
                .body(new Member.Response(1L, request.getName()));
    }
}
