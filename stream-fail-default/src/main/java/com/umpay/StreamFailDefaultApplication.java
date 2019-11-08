package com.umpay;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.Output;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@EnableBinding(StreamFailDefaultApplication.TestTopic.class )
@SpringBootApplication
public class StreamFailDefaultApplication {

    public static void main(String[] args) {

        SpringApplication.run(StreamFailDefaultApplication.class, args);
    }


    @RestController
    static class TestController {

        @Autowired
        private TestTopic testTopic;

        /**
         * 消息生产接口
         * @param message
         * @return
         */
        @GetMapping("/sendMessage")
        public String messageWithMQ(@RequestParam String message) {
            testTopic.output().send(MessageBuilder.withPayload(message).build());
            return "ok";
        }

    }

    /**
     * 消息消费逻辑
     */
    @Slf4j
    @Component
    static class TestListener {

        int counter = 1;

        @StreamListener(TestTopic.INPUT)
        public void receive(String payload) {
            log.info("Received: " + payload);
            if (counter == 3) {
                counter = 1;
                return;
            } else {
                counter++;
                throw new RuntimeException("Message consumer failed!");
            }
        }

    }

    interface TestTopic {

        String OUTPUT = "example-topic-output";
        String INPUT = "example-topic-input";

        @Output(OUTPUT)
        MessageChannel output();

        @Input(INPUT)
        SubscribableChannel input();

    }

}
