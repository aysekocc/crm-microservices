package com.aysekoc.order_service.controllers;

import com.aysekoc.order_service.client.ProductClient;
import com.aysekoc.order_service.entity.Order;
import io.github.aysekocc.event.order.OrderCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

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

        OrderCreatedEvent orderCreatedEvent = new OrderCreatedEvent("abc123", LocalDate.now());


        streamBridge.send("orderCreatedFunction-out-0",orderCreatedEvent);
        return "Order Service";
    }
}