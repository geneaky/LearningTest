package com.example.springdatajparedis.controller;

import com.example.springdatajparedis.HashMapping;
import com.example.springdatajparedis.Person;
import com.example.springdatajparedis.PersonRepository;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PersonController {

  private final PersonRepository personRepository;

  @GetMapping("/person")
  public Person basicCrudOp() {
    Person person = new Person("ju", "changrune");

    Person save = personRepository.save(person);
    System.out.println("save" + " " + save);
    long count = personRepository.count();
    System.out.println("count = " + count);

    Optional<Person> byId = personRepository.findById(person.getId());
    if (byId.isPresent()) {
      Person person1 = byId.get();
      person1.setLastName("jju");
      System.out.println("(person1==person) = " + (person1 == person));

      personRepository.save(person1);
    }

    Optional<Person> person1 = personRepository.findById(person.getId());
    Optional<Person> person2 = personRepository.findById(person.getId());
    System.out.println("(person==person1) = " + (person == person1.get()));
    System.out.println("(person1==person2) = " + (person1 == person2));
    return person1.get();
  }
}
