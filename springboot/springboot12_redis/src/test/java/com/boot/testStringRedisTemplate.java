package com.boot;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

/**
 * @author Alonso
 */
@SpringBootTest
public class testStringRedisTemplate {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void get(){
        ValueOperations<String, String> ops = stringRedisTemplate.opsForValue();
        System.out.println(ops.get("name2"));
    }
}
