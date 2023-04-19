package com.elikhcode.scam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class ScamApplication {
    public static void main(String[] args) {
        SpringApplication.run(ScamApplication.class,args);
    }
}
