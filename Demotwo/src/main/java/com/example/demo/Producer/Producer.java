package com.example.demo.Producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;


@Component
public class Producer {
    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Value("${client.kafka.producer.topic}")
    private String topic;
    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;


    public void sendMsg1(String msg){
        LOG.info("Log info Producer App DemoTwo");
        kafkaTemplate.send(topic, msg);

    }
}
