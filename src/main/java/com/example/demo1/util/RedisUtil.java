package com.example.demo1.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {

    @Autowired
    RedisTemplate redisTemplate;

    public Object get(Object key) {
        if(key != null) {
            return redisTemplate.opsForValue().get(key);
        } else {
            return null;
        }
    }

    public boolean set(Object key, Object value) {
        if(key == null || value == null) {
            return false;
        }
        redisTemplate.opsForValue().set(key, value);
        return true;
    }

    public boolean set(Object key, Object value, long time) {
        if(key == null || value == null || time < 0) {
            return false;
        }
        redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
        return true;
    }

    public long del(Object... key) {
        if(key == null && key.length > 0) {
            return 0;
        }
        try {
            if(key.length == 1) {
                return redisTemplate.delete(key)?1:0;
            } else {
                return redisTemplate.delete(new ArrayList(Arrays.asList(key)));
            }
        } catch (Exception e) {
             return 0;
        }
    }

}
