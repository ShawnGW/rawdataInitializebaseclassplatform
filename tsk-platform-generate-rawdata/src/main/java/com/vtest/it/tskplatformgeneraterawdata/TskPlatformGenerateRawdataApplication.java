package com.vtest.it.tskplatformgeneraterawdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TskPlatformGenerateRawdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(TskPlatformGenerateRawdataApplication.class, args);
    }

}
