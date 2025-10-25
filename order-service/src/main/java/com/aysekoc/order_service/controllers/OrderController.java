package com.aysekoc.order_service.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final RestClient restClient;
    public OrderController(RestClient.Builder restClientBuilder) {
        restClient = restClientBuilder.baseUrl("http://localhost:8086").build();
    }

    @GetMapping
    public String get(){
        // istek at
        // anında cevap al (cevabı bekle)
        // cevabı işle

        String response = restClient.get().uri("/api/v1/product").retrieve().body(String.class);
        System.out.println("Product serviceden gelen cevap: " + response);

        // mesajı gönder ve işleme devam et
        return "Order Service";
    }
}