package com.misicode.eggnews;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoAuditing
@EnableMongoRepositories(basePackages = "com.misicode.eggnews.repositories")
public class EggNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EggNewsApplication.class, args);
    }

}
