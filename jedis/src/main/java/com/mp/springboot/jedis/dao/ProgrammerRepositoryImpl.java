package com.mp.springboot.jedis.dao;

import com.mp.springboot.jedis.model.Programmer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class ProgrammerRepositoryImpl implements ProgrammerRepository {

    public static final String REDIS_LIST_KEY = "ProgrammerList";

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Autowired
    @Qualifier("listOperations")
    private ListOperations<String, Programmer> listOps;


    public void setProgrammer(String id, String programmer){
        redisTemplate.opsForValue().set(id, programmer);
        redisTemplate.expire(id, 20, TimeUnit.SECONDS);
    }

    public String getProgrammer(String id){
        return (String)redisTemplate.opsForValue().get(id);
    }

    @Override
    public void addToProgrammerList(Programmer programmer) {
        listOps.leftPush(REDIS_LIST_KEY, programmer);
        //redisTemplate.opsForList().leftPush(REDIS_LIST_KEY, programmer);
    }

    @Override
    public List<Programmer> getProgrammers() {
        return listOps.range(REDIS_LIST_KEY, 0, -1);
    }

    @Override
    public Long getProgrammersListCount() {
        return listOps.size(REDIS_LIST_KEY);
    }
}
