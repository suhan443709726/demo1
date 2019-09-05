package com.example.demo1.service;

import com.example.demo1.util.RedisUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Autowired
    RedisUtil redisUtil;

    @Async
    public void doService() {
        logger.info("开始执行异步任务");
        try {
            Thread.sleep(10000);
            redisUtil.set("task","success",30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("异步任务执行结束");
    }

    public String getTask() {
        if(redisUtil.get("task") == null) {
            return null;
        } else {
            return (String)redisUtil.get("task");
        }
    }
}
