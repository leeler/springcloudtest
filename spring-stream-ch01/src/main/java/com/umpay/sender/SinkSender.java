 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.sender;

 import com.google.gson.Gson;
 import com.umpay.moudle.User;
 import lombok.extern.slf4j.Slf4j;
 import org.springframework.cloud.stream.annotation.EnableBinding;
 import org.springframework.cloud.stream.messaging.Source;
 import org.springframework.context.annotation.Bean;
 import org.springframework.integration.annotation.InboundChannelAdapter;
 import org.springframework.integration.annotation.Poller;
 import org.springframework.integration.core.MessageSource;
 import org.springframework.messaging.support.GenericMessage;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-07 16:38
  **/
// @EnableBinding(value = {Source.class})
 @Slf4j
 public class SinkSender {

     private User user = new User();
     private int age = 0;

     @Bean
     @InboundChannelAdapter(value = Source.OUTPUT/*, poller = @Poller(fixedDelay = "2000")*/)
     public MessageSource<String> timerMessageSource() {
         age += 1;
         user.setName("lile");
         user.setAge(age);

         log.info("send user age is" + age);
         Gson gson = new Gson();
         String mes = gson.toJson(user);
         return () -> new GenericMessage<>(mes);
     }
 }
