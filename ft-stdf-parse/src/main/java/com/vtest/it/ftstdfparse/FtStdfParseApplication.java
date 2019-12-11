package com.vtest.it.ftstdfparse;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class FtStdfParseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtStdfParseApplication.class, args);
    }

}
