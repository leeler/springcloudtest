 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.listener;

 import com.umpay.topic.TestTopic;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.cloud.stream.annotation.StreamListener;
 import org.springframework.stereotype.Component;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-08 14:49
  **/
 @Slf4j
 @Component
 public class TestListener {

     @StreamListener(TestTopic.INPUT)
     public void receive(String payload) {
         log.info("Received: " + payload);
         throw new RuntimeException("BOOM!");
     }
 }
