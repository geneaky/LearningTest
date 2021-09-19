package com.example.springdatajparedis;

import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.hash.HashMapper;
import org.springframework.data.redis.hash.ObjectHashMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class HashMapping {

  private final RedisTemplate<String, String> redisTemplate;

  ObjectHashMapper hashMapper = new ObjectHashMapper();

  public void writeHash(String key, Person person) {

    HashOperations<String, byte[], byte[]> hashOperations = redisTemplate.opsForHash();
    Map<byte[], byte[]> mappedHash = hashMapper.toHash(person);
    hashOperations.putAll(key, mappedHash);
  }

  public Person loadHash(String key) {

    HashOperations<String, byte[], byte[]> hashOperations = redisTemplate.opsForHash();
    Map<byte[], byte[]> loadedHash = hashOperations.entries(key);
    return (Person) hashMapper.fromHash(loadedHash);

  }
}
