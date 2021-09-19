package com.example.springdatajparedis;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

@RedisHash("member")
@Data
@NoArgsConstructor
public class Member {

  @Id
  String id;

  String memberName;
  String memberAge;

  public Member(String memberName, String memberAge) {
    this.memberName = memberName;
    this.memberAge = memberAge;
  }

  public Member(String memberName) {
    this.memberName = memberName;
  }
}
