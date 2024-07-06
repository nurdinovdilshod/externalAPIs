package com.company;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class RestTemplatesApplication {

    public static void main(String[] args) {
        SpringApplication.run(RestTemplatesApplication.class, args);
    }


}
