package com.example.playground.controller;

import com.example.playground.dto.MemberRequest;
import com.example.playground.dto.MemberResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("annotation")
public class ReactiveController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello WebFlux!");
    }

    @GetMapping("/hello/{name}")
    public Mono<String> helloName(@PathVariable final String name) {
        return Mono.just(String.format("Hello %s", name));
    }

    @GetMapping("/hello/bad")
    public Mono<ResponseEntity<String>> bad() {
        return Mono.just(ResponseEntity.badRequest().body("bad"));
    }

    @PostMapping("/hello")
    public Mono<MemberResponse> helloUnlucky(@RequestBody final MemberRequest memberRequest) {
        return Mono.just(new MemberResponse(memberRequest.getName()));
    }
}
