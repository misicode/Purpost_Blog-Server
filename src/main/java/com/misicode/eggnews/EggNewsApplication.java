package com.misicode.eggnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class EggNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggNewsApplication.class, args);
    }

}
