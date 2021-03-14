package com.example.demo.Listener;


import com.example.demo.config.MassageDto;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.producer.internals.Sender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class ListenerMsg {

    private static final Logger LOG = LoggerFactory.getLogger(ListenerMsg.class);

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @KafkaListener(topics="msg1")
    public void msgListener1(String msg, ConsumerRecord<String, String> record){
        Gson g = new Gson();
        MassageDto p = g.fromJson(msg, MassageDto.class);
        LOG.info("Log info listener App DemoOne");
        System.out.println("Полученно:  \n"+"Topic : "+record.topic()+"\nMessage:"+ p.getMassage() +"\n"+ "Response time: "+p.TimeResponseResult());

    }


}
