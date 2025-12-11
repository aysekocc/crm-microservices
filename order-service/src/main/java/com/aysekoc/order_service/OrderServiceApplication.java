package com.aysekoc.order_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication(scanBasePackages = "com.aysekoc.order_service")
@EnableFeignClients
public class OrderServiceApplication {

    public static void main(String[] args) {

        System.out.println("spring boot kafka running..");
        SpringApplication.run(OrderServiceApplication.class, args);
    }

}


