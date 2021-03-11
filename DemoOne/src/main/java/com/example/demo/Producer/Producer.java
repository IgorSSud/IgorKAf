package com.example.demo.Producer;

import com.example.demo.Listener.ListenerMsg;
import com.example.demo.TimeResponse.TimeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@RestController
public class Producer {

    Date data = new Date();



    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @PostMapping
    @RequestMapping("msg")
    public void sendMsg(String msgId, String msg){
        TimeResponse.setRequestTime(data.getTime());
        ListenableFuture<SendResult<String, String>> future = kafkaTemplate.send("msg", msgId, msg);
        LOG.info("Producer AppDemoOne  Topic = '{}' |  Massage '{}' | Massage ID '{}'  |"  ,"msg",msg,msgId);
        kafkaTemplate.flush();

    }


}
