package com.aysekoc.notification_service.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;


@Service
public class KafkaConsumer {

    @KafkaListener(topics = "send-topic", groupId = "consumer-group")
    public void listen(String message) {
        System.out.println("Consumer aldı: " + message);
    }
}
