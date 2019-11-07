 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.config;

 import org.springframework.amqp.core.Queue;
 import org.springframework.context.annotation.Bean;
 import org.springframework.context.annotation.Configuration;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-07 15:29
  **/
 @Configuration
 public class RabbitConfig {

     @Bean
     public Queue helloQueue() {
         return new Queue("hello");
     }
 }
