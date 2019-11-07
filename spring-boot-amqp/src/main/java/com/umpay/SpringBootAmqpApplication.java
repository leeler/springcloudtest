package com.umpay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class SpringBootAmqpApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringBootAmqpApplication.class, args);
        log.info("Application is running==========================");
    }

}
