 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.sender;

 import org.springframework.amqp.core.AmqpTemplate;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.stereotype.Component;

 import java.util.Date;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-07 15:27
  **/
 @Component
 public class AmqpSender {

     @Autowired
     private AmqpTemplate rabbitTemplate;

     public void send() {
         String context = "hello " + new Date();
         System.out.println("Sender : " + context);
         this.rabbitTemplate.convertAndSend("hello", context);
     }
 }
