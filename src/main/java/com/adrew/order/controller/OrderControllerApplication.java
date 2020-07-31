package com.adrew.order.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by Andre on 30.07.2020.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableScheduling
public class OrderControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderControllerApplication.class);
    }
}

