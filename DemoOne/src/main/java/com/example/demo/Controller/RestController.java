package com.example.demo.Controller;

import com.example.demo.config.MassageDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.sql.Timestamp;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    @Autowired
    Producer producer;



    @PostMapping
    @RequestMapping("msg")
    public void sendMsg(@RequestBody MassageDto massageDto ){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        massageDto.setTimeRequest(timestamp.getTime());
        producer.sendMsg1(massageDto);

    }


}
