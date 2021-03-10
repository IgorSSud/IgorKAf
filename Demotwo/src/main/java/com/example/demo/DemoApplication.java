package com.example.demo;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.KafkaListener;

@EnableKafka
@SpringBootApplication
public class DemoApplication {



/*	@KafkaListener(topics="msg")
	public void msgListener(String msg, ConsumerRecord<String, String> record) {
		System.out.println(record.topic() + ": " + msg);
	}*/
	@KafkaListener(topics="msg1")
	public void msgListener1(String msg, ConsumerRecord<String, String> record){
			System.out.println(record.topic()+": "+ msg);
}
/*	@KafkaListener(topics="msg")
	public void orderListener(ConsumerRecord<String, String> record){

		System.out.println(record.partition());
		System.out.println(record.key());
		System.out.println(record.value());
	}*/




	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);


	}

}
