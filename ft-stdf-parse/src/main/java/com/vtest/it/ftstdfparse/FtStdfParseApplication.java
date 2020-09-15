package com.vtest.it.ftstdfparse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author shawn.sun
 * @date 2020-9-15 13:58:20
 */
@SpringBootApplication
@EnableScheduling
public class FtStdfParseApplication {

    public static void main(String[] args) {
        SpringApplication.run(FtStdfParseApplication.class, args);
    }

}
