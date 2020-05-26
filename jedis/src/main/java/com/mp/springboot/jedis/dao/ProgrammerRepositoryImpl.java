package com.mp.springboot.jedis.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {


    @Autowired
    private RedisTemplate<String, Object> redisTemplate;


    public void setProgrammer(String id, String programmer){
        redisTemplate.opsForValue().set(id, programmer);
        redisTemplate.expire(id, 20, TimeUnit.SECONDS);
    }

    public String getProgrammer(String id){
        return (String)redisTemplate.opsForValue().get(id);
    }
}
