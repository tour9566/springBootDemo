package com.example.demo.schedulTask;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class Test {
    @Scheduled(cron = "0/1 * * * * ?")
    public void test(){
        log.info("logback的日志信息过来了");
        log.error("logback的错误信息过来了");
        System.out.println("1111111");
    }
}
