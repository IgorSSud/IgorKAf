package com.example.demo.Producer;

import com.example.demo.Listener.ListenerMsg;
import com.example.demo.config.MassageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.crypto.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

@RestController
public class Producer {

    private static final Logger LOG = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, MassageDto> kafkaTemplate;

    @PostMapping
    @RequestMapping("msg")
    public void sendMsg(@RequestBody MassageDto massageDto ){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        massageDto.setTimeRequest(timestamp.getTime());
        ListenableFuture<SendResult<String, MassageDto>> future = kafkaTemplate.send("msg",massageDto.getId(), massageDto);
        LOG.info("Log info producer App DemoOne");
//        System.out.println("ОТПРАВЛЕННО :" +massageDto.toString());
        kafkaTemplate.flush();
    }
}
