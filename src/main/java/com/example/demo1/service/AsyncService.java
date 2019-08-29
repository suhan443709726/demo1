package com.example.demo1.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class AsyncService {

    Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @Async
    public void doService() {
        logger.info("开始执行异步任务");
        try {
            Thread.sleep(10000);
            //向redis中存数据
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        logger.info("异步任务执行结束");
    }
}
