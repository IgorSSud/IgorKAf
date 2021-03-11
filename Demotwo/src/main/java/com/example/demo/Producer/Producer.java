package com.example.demo.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;


@Component
public class Producer {
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

  /*  @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMsg1(String msgId, String msg){
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("msg1", msgId, msg);
        LOG.info("Producer AppDemoOne  Topic = '{}' |  Massage '{}' | Massage ID '{}'  |"  ,"msg",msg,msgId);
        kafkaTemplate.flush();
    }
*/
}
