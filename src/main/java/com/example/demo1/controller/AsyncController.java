package com.example.demo1.controller;

import com.example.demo1.service.AsyncService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AsyncController {

    @Autowired
    AsyncService asyncService;

    Logger logger = LoggerFactory.getLogger(AsyncService.class);

    @GetMapping("/async")
    public void testAsync() {
        logger.info("调用方法开始");
        asyncService.doService();
        logger.info("调用方法结束");
    }
}
