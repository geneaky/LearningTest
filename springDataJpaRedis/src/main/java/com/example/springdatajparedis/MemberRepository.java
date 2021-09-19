package com.example.springdatajparedis;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface MemberRepository extends CrudRepository<Member, String>,
    QueryByExampleExecutor<Member> {
  
}
