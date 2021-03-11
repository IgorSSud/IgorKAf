package com.example.demo.Listener;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class Listener {

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    private static final Logger LOG = LoggerFactory.getLogger(Listener.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @KafkaListener(topics="msg")
    public void msgListener(String msg, ConsumerRecord<String, String> record) {

        LocalDateTime dt= LocalDateTime.now();
        kafkaTemplate.send("msg1","OK");
        LOG.info("Listener AppDemoOne Topic = '{}' |  Massage '{}' |  Partition '{}'  |"  ,record.topic(),record.value(),record.partition());
        LOG.info("Producer AppDemoOne  Topic = '{}' |  Massage '{}' |"  ,"msg",msg);
        System.out.println("["+dt.format(myFormatObj)+"] "+record.topic() + ": " + msg);
    }

}
