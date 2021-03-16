package com.example.demo.Listener;

import com.example.demo.Producer.Producer;
import com.example.demo.config.MassageDto;
import com.google.gson.Gson;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
public class Listener {

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private final Gson g = new Gson();
    private static final Logger LOG = LoggerFactory.getLogger(Listener.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;
    @Autowired
    Producer producer;


    @KafkaListener(topics="msg")
    public void msgListener(String msg, ConsumerRecord<String, String> record) {
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());


        MassageDto p = g.fromJson(msg, MassageDto.class);
        LOG.info("Log info listener App DemoTwo");
        System.out.println("Полученно:  \n"+"Topic : "+record.topic()+"\nMessage:"+ p.getMassage() +"\n");

        p.setMassage("OK");
        p.setTimeResponse(timestamp.getTime());

        producer.sendMsg1(g.toJson(p));

//       System.out.println("ОТПРАВЛЕННО : "+p.toString());
    }

}
