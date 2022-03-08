package com.example.playground;

import com.example.playground.domain.Member;
import com.example.playground.domain.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class PlayGroundApplicationTests {

    @MockBean
    private MemberRepository memberRepository1;

    @Mock
    private MemberRepository memberRepository2;

    @Autowired
    private ApplicationContext context;

    private final Member member1 = new Member("unluckyjung");
    private final Member member2 = new Member("jys");

    @BeforeEach
    void setUp() {
        given(memberRepository1.findById(1L)).willReturn(Optional.of(member1));
    }

    @Test
    void mockBeanTest() {
        MemberRepository memberRepositoryInIOC = context.getBean(MemberRepository.class);
        assertThat(memberRepositoryInIOC.findById(1L)).isEqualTo(memberRepository1.findById(1L));
    }

    @Test
    void mockTest() {
        given(memberRepository2.findById(1L)).willReturn(Optional.of(member2));

        MemberRepository memberRepositoryInIOC = context.getBean(MemberRepository.class);
        assertThat(memberRepositoryInIOC.findById(1L)).isNotEqualTo(memberRepository2.findById(1L));
    }
}
