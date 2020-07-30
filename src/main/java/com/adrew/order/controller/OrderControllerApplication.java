package com.adrew.order.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

/**
 * Created by Andre on 30.07.2020.
 */
@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class OrderControllerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OrderControllerApplication.class);
    }
}

