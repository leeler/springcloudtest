 /*
  *Copyright (c) 2003, 2018, UMF and/or its affiliates. All rights reserved.
  *
  */
 package com.umpay.topic;

 import org.springframework.cloud.stream.annotation.Input;
 import org.springframework.cloud.stream.annotation.Output;
 import org.springframework.messaging.MessageChannel;
 import org.springframework.messaging.SubscribableChannel;

 /**
  * @program: springcloudtest
  * @description: TODO
  * @author: lile
  * @create: 2019-11-08 14:43
  **/
 public interface TestTopic {

     String OUTPUT = "example-topic-output";
     String INPUT = "example-topic-input";

     @Output(OUTPUT)
     MessageChannel output();

     @Input(INPUT)
     SubscribableChannel input();
 }
