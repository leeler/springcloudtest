 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.controller;

 import com.umpay.topic.TestTopic;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.integration.support.MessageBuilder;
 import org.springframework.web.bind.annotation.GetMapping;
 import org.springframework.web.bind.annotation.RequestParam;
 import org.springframework.web.bind.annotation.RestController;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-08 14:45
  **/
 @Slf4j
 @RestController
 public class TestController {

     @Autowired
     private TestTopic testTopic;

     @GetMapping("/sendMessage")
     public String messageWithMQ(@RequestParam String message) {
         testTopic.output().send(MessageBuilder.withPayload(message).build());
         return "ok";
     }

 }
