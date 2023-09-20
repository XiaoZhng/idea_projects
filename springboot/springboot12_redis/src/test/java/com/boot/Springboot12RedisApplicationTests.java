package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

@SpringBootTest
class Springboot12RedisApplicationTests {

	@Autowired
	private RedisTemplate redisTemplate;

	@Test
	void set() {
		ValueOperations valueOperations = redisTemplate.opsForValue();
		valueOperations.set("name2", "tom");
	}

	@Test
	void get() {
		ValueOperations valueOperations = redisTemplate.opsForValue();
		System.out.println(valueOperations.get("name"));
	}

	@Test
	public void hset(){
		HashOperations hashOperations = redisTemplate.opsForHash();
		hashOperations.put("info", "name", "tom");
	}

	@Test
	public void hget(){
		HashOperations hashOperations = redisTemplate.opsForHash();
		System.out.println(hashOperations.get("info", "name"));
	}

}
