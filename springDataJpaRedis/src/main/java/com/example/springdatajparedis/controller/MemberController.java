package com.example.springdatajparedis.controller;

import com.example.springdatajparedis.Member;
import com.example.springdatajparedis.MemberRepository;
import com.example.springdatajparedis.Person;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MemberController {

  private final MemberRepository memberRepository;

  @GetMapping("/member")
  public List<Member> findMemoryMemeber() {

    for (int i = 0; i < 100; i++) {
      Member member = new Member("testMember", String.valueOf(i));
      memberRepository.save(member);
    }

    ExampleMatcher exampleMatcher = ExampleMatcher.matching()
        .withIgnorePaths("memberName")
        .withIgnoreNullValues();

    Member member = new Member("testMember");

    Iterable<Member> all = memberRepository
        .findAll(Example.of(new Member(), ExampleMatcher.matchingAny()));
    for (Member test : all) {
      System.out.println(test.getMemberAge());
    }

    return (List<Member>) all;
  }
}
