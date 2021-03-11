package com.example.demo.Listener;

import com.example.demo.TimeResponse.TimeResponse;
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
    Date date = new Date();
    private static final Logger LOG = LoggerFactory.getLogger(ListenerMsg.class);

    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    @KafkaListener(topics="msg1")
    public void msgListener1(String msg, ConsumerRecord<String, String> record){
        LocalDateTime dt= LocalDateTime.now();
        TimeResponse.setResponseTime(date.getTime());
        LOG.info("Listener AppDemoOne Topic = '{}' |  Massage '{}' |  Partition '{}'  |"  ,record.topic(),record.value(),record.partition());
        System.out.println("["+dt.format(myFormatObj)+"] "+record.topic() + ": " + msg + " Time Response : "+TimeResponse.getResultResponseTime(TimeResponse.getRequestTime(),TimeResponse.getResponseTime())+"ms");
    }

}
