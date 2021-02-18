package com.ironhack.bankingsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class BankingsystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingsystemApplication.class, args);
    }

}
