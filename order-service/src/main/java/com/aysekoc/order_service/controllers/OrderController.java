package com.aysekoc.order_service.controllers;

import com.aysekoc.order_service.client.ProductClient;
import com.aysekoc.order_service.entity.Order;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/order")
@RequiredArgsConstructor
public class OrderController {
    private final ProductClient productClient;
    private final StreamBridge streamBridge;

    @GetMapping
    public String get() {
        //sync iletişim
        //String response = productClient.get();
        //System.out.println(response);

        //kafkaya mesaj gönder

        // TODO: Kafkadan common bir classı gönder.
        Order order = new Order();
        order.setId("abc123");
        //


        streamBridge.send("orderCreatedFunction-out-0","Mesaj123");
        return "Order Service";
    }
}