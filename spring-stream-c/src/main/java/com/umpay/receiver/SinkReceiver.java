 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.receiver;

 import com.umpay.moudle.User;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.cloud.stream.annotation.EnableBinding;
 import org.springframework.cloud.stream.annotation.StreamListener;
 import org.springframework.cloud.stream.messaging.Sink;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-07 16:36
  **/
 @EnableBinding(value = {Sink.class})
 @Slf4j
 public class SinkReceiver {

     @StreamListener(Sink.INPUT)
     public void receive(User user) {
         log.info("Received: " + user);
     }
 }
