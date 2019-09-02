package com.example.demo1;

import com.example.demo1.model.Animal;
import com.example.demo1.util.RedisUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisUtil redisUtil;

    @Test
    public void test() {
//        redisUtil.set("abc", new Animal(1,"cat"));
        redisUtil.set(1,null);
//        redisUtil.del("abc");
    }

}
