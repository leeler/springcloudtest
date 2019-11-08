package com.umpay;

import com.umpay.topic.TestTopic;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;

@EnableBinding(TestTopic.class)
@SpringBootApplication
public class StreamConsumeSelfApplication {

    public static void main(String[] args) {

        SpringApplication.run(StreamConsumeSelfApplication.class, args);
    }

}
