 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.reveiver;

 import org.springframework.amqp.rabbit.annotation.RabbitHandler;
 import org.springframework.amqp.rabbit.annotation.RabbitListener;
 import org.springframework.stereotype.Component;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-07 15:28
  **/
 @Component
 @RabbitListener(queues = "hello")
 public class Receiver {

     @RabbitHandler
     public void process(String hello) {
         System.out.println("Receiver : " + hello);
     }
 }
