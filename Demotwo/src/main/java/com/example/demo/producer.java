package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController

public class producer {
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

/*    @PostMapping
    @RequestMapping("msg")
    public void sendMsg(String msgId, String msg){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("msg", msgId, msg);
        ListenableFuture<SendResult<String, String>> future1 = kafkaTemplate.send("msg1", msgId, "OK");
        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }*/
    @PostMapping
    @RequestMapping("msg1")
    public void sendMsg1(String msgId, String msg){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("msg1", msgId, msg);

        future.addCallback(System.out::println, System.err::println);
        kafkaTemplate.flush();
    }

}
