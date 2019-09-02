package com.example.demo1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class RedisServer {

    @Autowired
    RedisTemplate redisTemplate;


}
