package com.aysekoc.notification_service.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "send-topic", groupId = "consumer-group")
    public void consume(String message) {
        System.out.println("Gelen Mesaj: " + message);
    }
}
