package com.redis.redis_configuration.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Cacheable(value = "myCache", key = "#id")
    public String getData(String id) {
        return (String) redisTemplate.opsForValue().get(id);
    }

//    @Cacheable(value = "myCache", key = "#id")
//    public void saveData(String id,String value) {
//         redisTemplate.opsForValue().set(id,value);
//    }
}