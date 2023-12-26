package com.vermeg.thoughtmachineproducerkafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class    ThoughtMachineProducerKafkaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThoughtMachineProducerKafkaApplication.class, args);
    }

}
