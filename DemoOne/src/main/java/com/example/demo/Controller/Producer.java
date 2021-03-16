package com.example.demo.Controller;

import com.example.demo.config.MassageDto;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.slf4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Producer {
    @Value("${client.kafka.producer.topic}")
    private String topic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);
    private final Gson g = new Gson();



    public void sendMsg1(MassageDto massageDto){
        kafkaTemplate.send(topic, g.toJson(massageDto));
        LOG.info("Producer AppDemoOne  Topic = '{}' |  Massage '{}' | Massage ID '{}'  |"  ,"msg");

    }
}
