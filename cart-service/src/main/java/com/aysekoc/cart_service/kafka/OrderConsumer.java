package com.aysekoc.cart_service.kafka;

import io.github.aysekocc.event.order.OrderCreatedEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class OrderConsumer {

    @Bean
    public Consumer<OrderCreatedEvent> orderCreatedFunction(){
        return event -> System.out.println(event.getId() + " " + event.getOrderDate().toString());
    }
}
